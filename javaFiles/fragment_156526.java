public class CustomAarrayAdapter extends ArrayAdapter
{

List<Ingredient> ingredientsList;
public CustomArrayAdapter(Context context, List<Ingredient> list)
{
   super(context,0,list);
   ingredientList = list;
}

@Override 
public View getView(int position, View convertView, ViewGroup parent) {  
ViewHolder holder; 

if (convertView == null) { 
convertView = mInflater.inflate(R.layout.row,parent,false);
// inflate custom layout called row 
holder = new ViewHolder();
holder.tv =(TextView) convertView.findViewById(R.is.textView1);  
// initialize textview
convertView.setTag(holder);
}
else
{
      holder = (ViewHolder)convertView.getTag();
}
      Ingredient in = (Ingredient)ingredientsList.get(position);
      holder.tv.setText(in.name); 
      // set the name to the text;

return convertView;

}

static class ViewHolder
{

   TextView tv;
} 
}