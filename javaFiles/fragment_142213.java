// add your first fragment 
 FragmentTransaction transaction = getFragmentManager().beginTransaction().add(frame_container1 , YOUR_FIRST_FRAGMENT).commit;

// add your second fragment 
 FragmentTransaction transaction = getFragmentManager().beginTransaction().add(frame_container2 , YOUR_SECOND_FRAGMENT).commit;



<linearLayout    android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:weightSum="2">
 <FrameLayout
            android:id="@+id/frame_container1"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_weight="1" />

<FrameLayout
            android:id="@+id/frame_container2"
            android:layout_width="match_parent"
            android:layout_height="match_parent" 
            android:layout_weight="1"/>

</linearLayout>