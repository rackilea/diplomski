package com.example.dhruv.dez;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Profile extends Fragment {
    @Nullable
    private TextView t1;
    private View rootView;//View variable to save fragment layout and use it to initialize views and use them
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, 
    Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.profile, container, false);

        t1 = rootView.findViewById(R.id.username);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        getActivity().setTitle("PROFILE");


    }

}