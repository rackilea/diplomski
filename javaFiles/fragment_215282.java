public class MyAdapter extends ArrayAdapter<MyEnum> {

    public MyAdapter (Context context) {
        super(context, 0, MyEnum.values());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         CheckedTextView text= (CheckedTextView) convertView;

         if (text== null) {
             text = (CheckedTextView) LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item,  parent, false);
         }

         text.setText(getItem(position).getDescriptionResourceId());

         return text;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        CheckedTextView text = (CheckedTextView) convertView;

        if (text == null) {
            text = (CheckedTextView) LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item,  parent, false);
        }

        text.setText(getItem(position).getTitle());

        return text;
    }
}