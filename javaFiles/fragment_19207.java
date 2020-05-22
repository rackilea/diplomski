public class ViewUtils
 {
 public static void setViewWidths(View view, View[] views) 
 {
    int w = view.getWidth();
    int h = view.getHeight();
    for (int i = 0; i < views.length; i++) 
    {
        View v = views[i];
        v.layout((i + 1) * w, 0, (i + 2) * w, h);
    }
 }


public static void initListView(Context context, ListView listView, String prefix, int numItems, int layout) 
{
    // By using setAdpater method in listview we an add string array in list.
    String[] arr = new String[numItems];
    for (int i = 0; i < arr.length; i++)
    {
        arr[i] = prefix + (i + 1);
    }
    listView.setAdapter(new ArrayAdapter<String>(context, layout, arr));
    listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {

        }
    });
    } 
 }