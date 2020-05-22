public class MainActivity extends Activity implements OnTaskCompleteListener{    

private ArrayList list;
    ...
    @Override
    public void onCreate(Bundle savedInstanceState) {
        ...
        try{
            SimpleAsyncTask mTask = new SimpleAsyncTask();
            mTask.execute(resource); 
        }catch (Exception e){}


       ...
    }

    private String[] mStrings={
        "http://resourse1.com",
        "http://resourseN.com",
    };   

    @Override
    private void onTaskComplete(ArrayList taskList){
    list = taskList;
            //String[] strArray = new String[ list.size() ];
            //int length = strArray.length; // lenght = 0
            //mStrings = new String[ list.size() ];
            //int length = strArray.length;
            //for( int j = 0; j < length; j++ ) {
            //    mStrings[j] = list.get(j).toString();
            //}  
//Instead of the above code you can also use this 
String[] array = list.toArray(new String[list.size()]);

// Create custom adapter for listview
adapter=new MyImageLoadAdapter(this, array);      
}
        }