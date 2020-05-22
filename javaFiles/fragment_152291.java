public class CheckboxAdapter extends ArrayAdapter
{
   Context context;
   List<Boolean> checkboxState;
   List<String> checkboxItems;
   public CheckboxAdapter(Context context, List<String> resource)
   {
      super(context, R.layout.form_checkbox_item ,resource);

      this.context = context;
      this.checkboxItems = resource;
      this.checkboxState = new ArrayList<Boolean>(Collections.nCopies(resource.size(), true));
   }

   public View getView(int position, View convertView, ViewGroup parent){

      LayoutInflater inflater = ((Activity)context).getLayoutInflater();
convertView = inflater.inflate(R.layout.form_checkbox_item, parent, false);
      TextView textView = (TextView) convertView.findViewById(R.id.textView1);
      CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox1);

      textView.setText(checkboxItems.get(position));
      cb.setChecked(checkboxState.get(position));
      return convertView;
   }