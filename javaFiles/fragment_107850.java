@Override
protected void publishResults(CharSequence constraint, FilterResults results) 
{
     // even if results.values is an empty List<Animal>, you want to notify your adapter!
     mAnimals = (List<Animal>) results.values;
     notifyDataSetChanged();
}