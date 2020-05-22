package com.example.testapp;

import com.example.main.util.testActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    private static final String[] COUNTRIES = new String[] { "Belgium",
            "France", "France_", "Italy", "Germany", "Spain" };
    private MyArrayAdapter adapter;
    Bundle savedInstanceState;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        adapter = new MyArrayAdapter(MainActivity.this);
        getListView().setAdapter(adapter);
    }

    private class MyArrayAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public MyArrayAdapter(Context con) {
            // TODO Auto-generated constructor stub
            mInflater = LayoutInflater.from(con);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return COUNTRIES.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            final ListContent holder;
            View v = convertView;
            if (v == null) {
                v = mInflater.inflate(R.layout.my_spinner_style, null);
                holder = new ListContent();

                holder.name = (TextView) v.findViewById(R.id.textView1);

                v.setTag(holder);
            } else {

                holder = (ListContent) v.getTag();
            }

            holder.name.setText("" + COUNTRIES[position]);
            holder.name.setOnClickListener(mOnTitleClickListener3);

            return v;
        }

    }

    static class ListContent {

        TextView name;

    }

    public OnClickListener mOnTitleClickListener3 = new OnClickListener() {
        public void onClick(View v) {
            final int position = getListView().getPositionForView(
                    (View) v.getParent());
            v.setBackgroundColor(Color.RED);
            startActivity(new Intent(MainActivity.this, testActivity.class));
            // Log.d("you are click on Ratings", "you are click on Ratings");
            // v.setBackgroundColor(Color.WHITE);
        }
    };

    protected void onRestart() {
        // adapter.notifyDataSetChanged();
        onCreate(savedInstanceState);
    };
}