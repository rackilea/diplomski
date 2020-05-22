import java.util.ArrayList;
import java.util.HashMap;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//Custom view for cityList

public class CustomItemsList extends BaseAdapter 
{
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private LayoutInflater inflater=null;
    Context ctx;

    public CustomItemsList(Activity a, ArrayList<HashMap<String, String>> d) 
    {
        ctx = a.getBaseContext();
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);       
    }

    public int getCount() 
    {
        return data.size();
    }

    public Object getItem(int position) 
    {
        return position;
    }

    public long getItemId(int position)
    {
        return position;
    }


    @SuppressLint("InflateParams")
    public View getView(int position, View convertView, ViewGroup parent) 
    {
        View vi=convertView;

        if(convertView==null)
            vi = inflater.inflate(R.layout.custom_items_list, null);

        TextView title = (TextView)vi.findViewById(R.id.more_item);
        TextView price = (TextView) vi.findViewById(R.id.itemPrice);

        HashMap<String, String> category = new HashMap<String, String>();
        category = data.get(position);

        title.setText(category.get("itemName"));
        price.setText(category.get("itemPrice"));
        String itemId = category.get("itemId");

        return vi;
    }
}