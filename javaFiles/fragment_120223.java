if (convertView != null)
        vHolder = (ViewHolder) convertView.getTag();                                // convertView is been recycled
    else {
        convertView = (View) mInflater.inflate(R.layout.list_item, null);           // Set content of new View with list_item.xml

        vHolder = new ViewHolder();
        vHolder.checkBox = ((CheckBox) convertView.findViewById(R.id.lstChkbox));   // Getting pointers
        vHolder.textView = ((TextView) convertView.findViewById(R.id.lstText));
        vHolder.imageView = ((ImageView) convertView.findViewById(R.id.listImage));

        vHolder.checkBox.setOnCheckedChangeListener(this);                          // Setting Listeners

        convertView.setTag(vHolder);
    }

    vHolder.checkBox.setId(position);                                               // This is part of the Adapter APi
    vHolder.textView.setId(position);                                               // Do not delete !!!
    vHolder.imageView.setId(position);


    if (mItems.get(position).getChecked()) {                                        // Setting parameters for the View from our mItems list
        vHolder.checkBox.setChecked(true);
    } else {
        vHolder.checkBox.setChecked(false);
    }

    vHolder.textView.setText(mItems.get(position).getText());
    vHolder.imageView.setImageDrawable(mItems.get(position).getmImage());

    return convertView;
}

public static class ViewHolder {
    CheckBox checkBox;
    TextView textView;
    ImageView imageView;
}

/*
 * Ok for this test but Toast are going to show every time the row comes into View
 */
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    Log.d(TAG, "Checked");
    int position = buttonView.getId();

    if (isChecked) {
        mItems.get(position).setChecked(true);
        Toast.makeText(context, mItems.get(position).getText(), Toast.LENGTH_LONG).show();
    } else {
        mItems.get(buttonView.getId()).setChecked(false);
    }
}