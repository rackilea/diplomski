package net.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.example.app.R;

import java.util.ArrayList;

public class MyObject_ListAdapter extends ArrayAdapter<MyObject> {

    // Source:
    // http://hmkcode.com/android-custom-listview-items-row/

    private ArrayList<MyObject> objects;
    private Context context;

    public MyObject_ListAdapter(Context context, ArrayList<MyObject> objects) {
        super(context, R.layout.myobject_list_item, objects);
        this.objects = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.fach_list_item, parent, false);

        // 3. Get the two text view from the rowView
        TextView column1 = (TextView) rowView.findViewById(R.id.column1);
        TextView column2 = (TextView) rowView.findViewById(R.id.column2);
        RelativeLayout item = (RelativeLayout) rowView.findViewById(R.id.item);

        // 4. Set the text for textView
        column1.setText(objects.get(position).getName());
        column2.setText(objects.get(position).getSecondName());


        // 5. return rowView
        return rowView;
    }
}