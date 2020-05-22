@Override
public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.ItemId) {
        Intent i = new Intent(YourActivityName.this, OtherActivity.class);
        startActivity(i);
    } 
    mdrawer.closeDrawer(GravityCompat.START);
    return true;

}


<android.support.v4.widget.DrawerLayout
xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:id="@+id/drawerlayout"
xmlns:app="http://schemas.android.com/apk/res-auto"
android:fitsSystemWindows="true">
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <include
        android:id="@+id/toolbar"
        layout="@layout/mytoolbar" />
    <android.support.design.widget.TabLayout
        android:id="@+id/tablayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        style="@style/AppTabLayout"
        app:tabTextAppearance="@style/AppTabTextAppearance"
        app:tabMode="fixed" />
    <android.support.v4.view.ViewPager
        android:id="@+id/viewpage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/tablayout" />
</LinearLayout>

<RelativeLayout xmlns:fab="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_alignEnd="@+id/material_design_android_floating_action_menu"
    android:layout_alignParentTop="true"
    android:layout_alignRight="@+id/material_design_android_floating_action_menu">
    <TextView
        android:id="@+id/textbar"
        android:layout_width="125dp"
        android:layout_height="30dp"
        android:layout_gravity="center"
        android:layout_marginBottom="100dp"
        android:layout_marginLeft="125dp"
        android:layout_marginTop="11dp"
        android:gravity="center"
        android:text="WACKTY"
        android:textColor="#01b698"
        android:textSize="24dp" />
    <RelativeLayout
        xmlns:fab="http://schemas.android.com/apk/res-auto"
        android:id="@+id/relativeLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_below="@+id/textmenu">

        <com.github.clans.fab.FloatingActionMenu
            android:id="@+id/menu"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentEnd="true"
            android:layout_alignParentRight="true"
            android:layout_marginBottom="20dp"
            android:layout_marginEnd="12dp"
            android:layout_marginRight="12dp"
            fab:menu_animationDelayPerItem="55"
            fab:menu_backgroundColor="@android:color/transparent"
            fab:menu_buttonSpacing="0dp"
            fab:menu_colorNormal="#ffffff"
            fab:menu_colorPressed="#ffffff"
            fab:menu_colorRipple="#99d4d4d4"
            fab:menu_fab_size="normal"
            fab:menu_icon="@drawable/ic_action_plus"
            fab:menu_labels_colorNormal="#c4c0c0"
            fab:menu_labels_colorPressed="#444"
            fab:menu_labels_colorRipple="#66efecec"
            fab:menu_labels_cornerRadius="0dp"
            fab:menu_labels_ellipsize="none"
            fab:menu_labels_hideAnimation="@anim/fab_slide_out_to_right"
            fab:menu_labels_margin="0dp"
            fab:menu_labels_maxLines="-1"
            fab:menu_labels_padding="1dp"
            fab:menu_labels_position="left"
            fab:menu_labels_showAnimation="@anim/fab_slide_in_from_right"
            fab:menu_labels_showShadow="false"
            fab:menu_labels_singleLine="false"
            fab:menu_labels_textColor="#000000"
            fab:menu_labels_textSize="14sp"
            fab:menu_openDirection="up">
            <com.github.clans.fab.FloatingActionButton
                android:id="@+id/projet"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:src="@drawable/ic_projeticon"
                fab:fab_colorNormal="#ffffff"
                fab:fab_colorPressed="#444"
                fab:fab_label="Projet"
                android:onClick="Projet"
                fab:fab_size="mini" />

            <com.github.clans.fab.FloatingActionButton
                android:id="@+id/événement"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:src="@drawable/ic_eventicon"
                fab:fab_colorNormal="#ffffff"
                fab:fab_colorPressed="#444"
                fab:fab_label="Événement"
                android:onClick="Evenement"
                fab:fab_size="mini" />

            <com.github.clans.fab.FloatingActionButton
                android:id="@+id/rendezvous"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="Rendezvous"
                android:src="@drawable/ic_action_rendez"
                fab:fab_colorNormal="#ffffff"
                fab:fab_colorPressed="#444"
                fab:fab_label="Rendez-Vous"
                fab:fab_size="mini" />

            <com.github.clans.fab.FloatingActionButton
                android:id="@+id/tache"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="runThis"
                android:src="@drawable/ic_action_task"
                fab:fab_colorNormal="#ffffff"
                fab:fab_colorPressed="#444"
                fab:fab_label="Tâches"
                fab:fab_size="mini" />
        </com.github.clans.fab.FloatingActionMenu>
    </RelativeLayout>
</RelativeLayout>
<android.support.design.widget.NavigationView
    android:id="@+id/navview"
    android:layout_width="wrap_content"
    android:layout_height="match_parent"
    android:layout_alignParentEnd="true"
    android:layout_alignParentRight="true"
    android:layout_alignParentTop="true"
    android:layout_gravity="start"
    android:background="#ededed"
    app:itemIconTint="#000000"
    app:itemTextColor="#000000"
    app:menu="@menu/menudeb">
</android.support.design.widget.NavigationView>
</android.support.v4.widget.DrawerLayout>