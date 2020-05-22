import java.util.List;

    import android.app.Activity;
    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.ImageView;
    import android.widget.TextView;

    public class MyPerformanceArrayAdapter extends ArrayAdapter<DefinitionObject>{
    private List<DefinitionObject> entries;
    private Activity activity;

    public MyPerformanceArrayAdapter(Activity a, int textViewResourceId, List<DefinitionObject> entries) {
    super(a, textViewResourceId, entries);
    this.entries = entries;
    this.activity = a;
    }

    public static class ViewHolder{
    public TextView item1;
    public ImageView item2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
    ViewHolder holder;
    if (v == null) {
        LayoutInflater vi =
            (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.custom_listview_row, null);
        holder = new ViewHolder();
        holder.item1 = (TextView) v.findViewById(R.id.clv_textView);
        holder.item2 = (ImageView) v.findViewById(R.id.clv_imageView);
        v.setTag(holder);
    }
    else
        holder=(ViewHolder)v.getTag();

    final DefinitionObject custom = entries.get(position);
    if (custom != null) {
        holder.item1.setText(custom.getWord());
        if(custom.getFav().equalsIgnoreCase("0"))
        {
            holder.item2.setImageResource(R.drawable.fav);
            holder.item2.setVisibility(holder.item2.INVISIBLE);
        }
        else
        {
            holder.item2.setImageResource(R.drawable.fav2);
        }
    }
    return v;
    }

    }