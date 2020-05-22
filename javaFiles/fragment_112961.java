public class MyAdapter extends Adapter {

private final ArrayList<String> items = new ArrayList<String>();

// ...

deleteRow(int position) {
    items.remove(position);
    notifyDataSetChanged();
}
//

@Override
public View getView(int position, View convertView, ViewGroup parent) {

    if(convertView == null) {
        Tag tag = new Tag();
        // inflate as usual, store references to widgets in the tag
        tag.button.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
                    deleteRow(position);
        }
    });
    }
    // don't forget to set the actual position for each row
    Tag tag = (Tag)convertView.getTag();
    // ...
    tag.position = position;
    // ...
}



class Tag {

    int position;

    TextView text1;
    // ...
    Button button;
}

}