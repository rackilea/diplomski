private void fillData() 
    {
        cursor = mDbAdapter.fetchAllSubjects();
        startManagingCursor(cursor);


        SubjectsAdapter subjectsAdapter = new SubjectsAdapter(this, cursor);
        setListAdapter(subjectsAdapter);
    }


//SubjectsAdapter.java - make changes to fix bugs/compilation errors. This is untested.
public class SubjectsAdapter extends ResourceCursorAdapter 
{
    public SubjectsAdapter(Context context, Cursor cur) {
        super(context, R.layout.subject_row, cur);
    }

    @Override
    public View newView(Context context, Cursor cur, ViewGroup parent) 
    {
         LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         return li.inflate(R.layout.subject_row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) 
    {           
        TextView titleText = (TextView)view.findViewById(R.id.title);
          titleText.setText(cursor.getString(cursor.getColumnIndex(DatabaseAdapter.KEY_TITLE)));

        //You can add code to retrieve other columns here.

        //This is where you retrieve the date in long format from cursor, convert it to a required format, and then using it.
        TextView beginTimeText = (TextView)view.findViewById(R.id.time);            
        Long lBeginDate = cursor.getLong(cursor.getColumnIndex(DatabaseAdapter.KEY_BEGIN));
        String sBeginDate = getFormattedDate(lBeginDate);           
        beginTimeText.setText(sBeginDate);
   }

    private String getFormattedDate(Long lDate)
    {
         SimpleDateFormat smdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");       
        String sDate = smdf.format( lDate ));
        return sDate;
    }
}