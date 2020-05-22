public class CustomAdapter extends ArrayAdapter<Person>{
  private final Activity context;

  private ArrayList<Person> Items;
  public CustomAdapter (Activity context, int layout,ArrayList<Person> persons) {
  super(context, layout, carriers);
 // TODO Auto-generated constructor stub

 this.context = context;
 this.Items = persons;

 }

 static class ViewHolder {
  public Button name;
  public Button family;


   }

@Override
 public View getView(int position, View convertView, ViewGroup parent) {
  final ViewHolder holder;
  // Recycle existing view if passed as parameter
  // This will save memory and time on Android
  // This only works if the base layout for all classes are the same
  View rowView = convertView;
  if (rowView == null) {
    LayoutInflater inflater = context.getLayoutInflater();
    rowView = inflater.inflate(R.layout.item, null, true);

    holder = new ViewHolder();
    holder.name= (TextView) rowView.findViewById(R.id.name);
     holder.family= (TextView) rowView.findViewById(R.id.family);
    rowView.setTag(holder);
   } else {
    holder = (ViewHolder) rowView.getTag();
   }

   holder.name.setText(Items.get(position).getName());
  holder.family.setText(Items.get(position).getFamily());


  return rowView;

 }

}