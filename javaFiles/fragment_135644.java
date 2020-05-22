package com.example.your.package.name;

    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context mContext;
    String[] arrayTitles;
    String[] arrayDescriptions;

    public CustomAdapter(Context mContext,String[] arrayTitles,String[] arrayDescriptions)
    {
        this.mContext = mContext;
        this.arrayTitles = arrayTitles;
        this.arrayDescriptions = arrayDescriptions;
    }

    @Override
    public int getCount() {
        return arrayTitles.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(parent.getContext());
            v = vi.inflate(R.layout.item_list_row, null);
        }

        TextView tvTitle = (TextView) v.findViewById(R.id.txtTitle);
        TextView tvDesc = (TextView) v.findViewById(R.id.txtDesc);

        tvTitle.setText(arrayTitles[position]);
        tvDesc.setText(arrayDescriptions[position]);

        return v;
    }
}