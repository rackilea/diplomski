public class CustomAdapter {
    public CustomAdapter(Context context){
        // connect to you database

    }


    public View getItemView(/*pass your db object*/, View v, ViewGroup parent){
        if (v == null) {
            v = View.inflate(getContext(), R.layout.row, null);
        }

        super.getItemView(object, v, parent);


        TextView textView = (TextView) v.findViewById(R.id.text1);
        textView.setText(/*dataObject.getdata*/);

        // Do this as much as necessary
    }
public void loadObject(){
   //Get all of your data, set each row in list view by calling getView
}