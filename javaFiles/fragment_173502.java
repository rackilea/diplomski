package com.joshuawitter.maps;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;
import com.joshuawitter.Base64;

/*
 * UsersOverlay.java
 * 
 * Description: The Google Maps overlay that displays the users on the map screen.
 * 
 * Author: Joshua Witter
 */

public class UsersOverlay extends Overlay {

    private static final String TAG = "Josh-UsersOverlay";

    // the activity that called this overlay
    private Activity m_caller;

    // the currently selected User
    private UserOnMap m_selectedUser;

    // list of User locations
    private ArrayList<UserOnMap> m_Users;

    // set the list of Users
    public void setUsers(ArrayList<UserOnMap> users) {

        // set the list of Users
        this.m_Users = users;
    }

    /*
     * Parameterized constructor.
     * 
     * @param caller the activity that created this overlay
     * @param Users a list of the Users to display
     */
    public UsersOverlay(Activity caller) {
        super();

        // reference the caller
        m_caller = caller;

        // make a new list of Users
        m_Users = new ArrayList<UserOnMap>(0);
    }

    /*
     * User tapped the map.
     * 
     * @param geoPoint the location the user tapped
     * @param mapView the map itself
     */
    @Override
    public boolean onTap(GeoPoint geoPoint, MapView mapView) {

        // get the User that was tapped
        UserOnMap user = getTappedUser(mapView, geoPoint);

        // if the user tapped on a User
        if (null != user) {

            // if this User is not already selected, select it
            m_selectedUser = (m_selectedUser != user) ? user : null;
        }

        // otherwise the user tapped nothing
        else {

            // deselect the selected user
            m_selectedUser = null;
        }

        // call through to the parent
        return super.onTap(geoPoint, mapView);
    }

    /*
     * Draw the overlay on the map.
     * 
     * @param canvas the canvas to draw on
     * @param mapView the map view
     * @param shadow should we draw the shadow?
     */
    @Override
    public void draw(Canvas canvas, MapView mapView, boolean shadow) {

        // draw the User icons
        drawUserIcons(canvas, mapView);

        // call the parent draw method
        super.draw(canvas, mapView, shadow);
    }

    /*
     * Draw the User icons on the map.
     * 
     * @param canvas the canvas to draw on
     * @param mapView the map view
     */
    private void drawUserIcons(Canvas canvas, MapView mapView) {

        // loop through the users
        for (UserOnMap user : m_Users) {

            // draw the icon for the User
            drawUserIcon(canvas, mapView, user);
        }

        // draw the selected User last so that it is on top
        if (null != m_selectedUser) {
            drawUserBubble(canvas, mapView, m_selectedUser);
        }
    }

    /*
     * Draw a User bubble overlay.
     * 
     * @param canvas the canvas to draw on
     * @param mapView the map view
     * @param user the User we are displaying the information for
     */
    private void drawUserBubble(Canvas canvas, MapView mapView, UserOnMap user) {

        // get the overlay point
        Projection projection = mapView.getProjection();
        Point pt = new Point();
        projection.toPixels(user.getLocation(), pt);

        // get the bubble bitmap ready
        Bitmap bubbleBitmap = BitmapFactory
                .decodeResource(m_caller.getResources(),
                        R.drawable.user_bubble);

        // get the dimensions of the bubble
        int height = bubbleBitmap.getHeight();
        int width = bubbleBitmap.getWidth();

        // calculate the offsets
        int xValue = pt.x - (width / 2);
        int yValue = pt.y - height - 20;

        // draw the icon
        canvas.drawBitmap(bubbleBitmap, xValue, yValue, null);

        // get the paint object
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setTextSize(24);

        // draw the text
        canvas.drawText("Current Location", xValue + 30, yValue + 33, paint);
    }

    /*
     * Draw a User icon overlay.
     * 
     * @param canvas the canvas to draw on
     * @param mapView the map view
     * @param user the User we are displaying the icon for
     */
    private void drawUserIcon(Canvas canvas, MapView mapView,
            UserOnMap user) {

        // get the overlay point
        Projection projection = mapView.getProjection();
        Point pt = new Point();
        projection.toPixels(user.getLocation(), pt);

        // get the icon
        Bitmap icon = BitmapFactory.decodeResource(m_caller.getResources(),
                user.getIconResource());

        // get the dimensions of the icon
        int height = icon.getHeight();
        int width = icon.getWidth();

        // calculate the offsets
        int xValue = pt.x - (width / 2);
        int yValue = pt.y - height;

        // draw the icon
        canvas.drawBitmap(icon, xValue, yValue, null);
    }

    /*
     * Determine which User was tapped by the user.
     * 
     * @param tapPoint where the user tapped
     * @param mapView the map view
     * @param UserOnMap the User was tapped, null if none
     */
    private UserOnMap getTappedUser(MapView mapView, GeoPoint tapPoint) {

        // get the screen coordinates that match our tap
        Point tapScreenCoordinates = new Point();
        mapView.getProjection().toPixels(tapPoint, tapScreenCoordinates);

        // loop through the User icons
        for (UserOnMap user : m_Users) {

            // if this is the currently selected User
            if (user == m_selectedUser) {

                // if we tapped its bubble
                if (hitUserBubble(mapView, tapPoint, user)) {

                    // we found the User
                    Log.d(TAG, "User " + user.getLastName() + " was tapped (bubble)");
                    return user;

                }
            }

            // otherwise if we tapped the icon for an User 
            if (hitUserIcon(mapView, tapPoint, user)) {

                // return the User
                Log.d(TAG, "User " + user.getLastName() + " was tapped (icon)");
                return user;
            }
        }

        // return the tapped User
        return null;
    }

    /*
     * Determine if an User's icon was tapped by the user.
     * 
     * @param tapPoint where the user tapped
     * @param mapView the map view
     * @param User the User we are checking
     * @param boolean true if the icon for this User was tapped
     */
    private boolean hitUserIcon(MapView mapView, GeoPoint tapPoint,
            UserOnMap user) {

        // get the screen coordinates that match our tap
        Point tapScreenCoordinates = new Point();
        mapView.getProjection().toPixels(tapPoint, tapScreenCoordinates);

        // get the screen coordinates for the User's location
        Point iconScreenCoordinates = new Point();
        mapView.getProjection().toPixels(user.getLocation(),
                iconScreenCoordinates);

        // get the icon for the User
        Bitmap icon = BitmapFactory.decodeResource(m_caller.getResources(),
                user.getIconResource());

        // calculate the icon hit box size
        int xValue = 50;
        int yValue = 50;

        // create a rectangle representing our icon
        RectF iconRectangle = new RectF();
        iconRectangle.set(-xValue, -yValue, xValue, yValue);
        iconRectangle.offset(iconScreenCoordinates.x, iconScreenCoordinates.y);

        // return true if the user tapped on the icon for this User
        return (iconRectangle.contains(tapScreenCoordinates.x,
                tapScreenCoordinates.y));
    }

    /*
     * Determine if an User's bubble was tapped by the user.
     * 
     * @param tapPoint where the user tapped
     * @param mapView the map view
     * @param User the User we are checking
     * @param boolean true if the bubble for this User was tapped
     */
    private boolean hitUserBubble(MapView mapView, GeoPoint tapPoint,
            UserOnMap user) {

        // get the screen coordinates that match our tap
        Point tapScreenCoordinates = new Point();
        mapView.getProjection().toPixels(tapPoint, tapScreenCoordinates);

        // get the screen coordinates for the User's location
        Point iconScreenCoordinates = new Point();
        mapView.getProjection().toPixels(user.getLocation(),
                iconScreenCoordinates);

        // get the bubble for the User
        Bitmap bubble = BitmapFactory.decodeResource(m_caller.getResources(),
                R.drawable.backup_map_current_location);

        // calculate the bubble hit box size
        int xValue = bubble.getWidth() * 2;
        int yValue = bubble.getHeight() * 2;

        // create a rectangle representing our bubble
        RectF iconRectangle = new RectF();
        iconRectangle.set(-xValue, -yValue, xValue, yValue);
        iconRectangle.offset(iconScreenCoordinates.x, iconScreenCoordinates.y);

        // return true if the user tapped on the bubble
        return (iconRectangle.contains(tapScreenCoordinates.x,
                tapScreenCoordinates.y));
    }
}