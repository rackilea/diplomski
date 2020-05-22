Class myListActivity extends Activity{
... some code here...
public void onCreate(Bundle savedInstanceState){
.....
myList.setAdapter(new myCustomAdapter());
.....
}

/**
*Custom Adapter class for the ListView containing data
*/
class myCustomAdapter extends BaseAdapter{

TextView userName;
/**
 * returns the count of elements in the Array that is used to draw the text in rows 
   * @see android.widget.Adapter#getCount()
 */
@Override
public int getCount() {
    //return the length of the data array, so that the List View knows how much rows it has to draw   
return DataArr.length;
}

/**
 * @param position The position of the row that was clicked (0-n)
 * @see android.widget.Adapter#getItem(int)
                     */
@Override
public String getItem(int position) {
    return null;
}

/**
 * @param position The position of the row that was clicked (0-n)
 * @see android.widget.Adapter#getItemId(int)
 */
@Override
public long getItemId(int position) {
    return position;
}

/**
 * Returns the complete row that the System draws.
 * It is called every time the System needs to draw a new row;
 * You can control the appearance of each row inside this function.
 * @param position The position of the row that was clicked (0-n)
 * @param convertView The View object of the row that was last created. null if its the first row
 * @param parent The ViewGroup object of the parent view
 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
 */
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;
    final int pos = position;
    if(row == null){
                    //getting custom layout to the row
        LayoutInflater inflater=getLayoutInflater();
        row=inflater.inflate(R.layout.list_row, parent, false);
    }
            //get the reference to the textview of your row. find the item with row.findViewById()
    userName= (TextView)row.findViewById(R.id.user_name);
    userName.setText(DataArr[position]);
return row; //the row that ListView draws
}
}
}