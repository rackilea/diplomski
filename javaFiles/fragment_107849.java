if (results.count == 0)
    notifyDataSetInvalidated();     // <-- this isn't right
else 
{
     mAnimals = (List<Animal>) results.values;
     notifyDataSetChanged();
}