public class listview extends Activity implements OnItemClickListener{

     ListView list;
     ListAdapter adapter;
     ArrayList<String> nameArray;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//xml should have an ListView element
        nameArray   =   new  ArrayList<String>();
        nameArray.add("Item1");
        nameArray.add("Item2");
        nameArray.add("Item3");
        nameArray.add("Item4");
        nameArray.add("Item5");
        list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(listview.this);
        adapter=new ListAdapter(listview.this, nameArray);
        list.setAdapter(adapter);
    }
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        showDialog(arg2);
    }
    @Override
    protected Dialog onCreateDialog(final int id) {
        Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete Event")
            .setCancelable(true)
            .setPositiveButton("Ok, Delete",
                    new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nameArray.remove(id);
                        adapter=new ListAdapter(listview.this, nameArray);
                        list.setAdapter(adapter);
                    }
                    })
            .setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                    });
        AlertDialog dialog = builder.create();
        dialog.show();
        return super.onCreateDialog(id);
    }
}