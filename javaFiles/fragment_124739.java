package com.example.androidlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomView extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] values;
    private final Integer[] images;

    //Constructor
    public CustomView(Activity context,String[] values, Integer[] images) {

            super(context, R.layout.single_row, values);
            this.context = context;
            this.values = values;
            this.images = images;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.single_row, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(values[position]);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        imageView.setImageResource(images[position]);
        return rowView;
    }
}