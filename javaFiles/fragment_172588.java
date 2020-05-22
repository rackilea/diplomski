package com.alg.amzar.spectrum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;



public class SongAdapter extends BaseAdapter {

private ArrayList<Song> songs;
private LayoutInflater songInf;

int[] photos={R.drawable.img_0, R.drawable.img_1,R.drawable.img_2};
Random ran=new Random();
// CHECK THIS:
public SongAdapter(Context c, ArrayList<Song> theSongs) {
    songs = theSongs;
    // CHECK THIS:
    songInf =  ( LayoutInflater )c.
                 getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

@Override
public int getCount() {
    return songs.size();
}

@Override
public Object getItem(int arg0) {
    // TODO Auto-generated method stub
    return null;
}

@Override
public long getItemId(int arg0) {
    // TODO Auto-generated method stub
    return 0;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    //map to song layout
    LinearLayout songLay = (LinearLayout)songInf.inflate
            (R.layout.song, null);
    //get title and artist views
    TextView songView = (TextView)songLay.findViewById(R.id.song_title);
    // CHECK THIS:
    ImageView img = (ImageView)songLay.findViewById(R.id.imagine);
    //get song using position
    Song currSong = songs.get(position);
    //get title and artist strings
    songView.setText(currSong.getTitle());
    // CHECK THIS:
    int i=ran.nextInt(photos.length);
    img.setImageResource(photos[i]);
    //set position as tag
    songLay.setTag(position);
    return songLay;
}

}