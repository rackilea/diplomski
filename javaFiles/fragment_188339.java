@Override
protected void publishResults(CharSequence constraint,  FilterResults results) {
    homelist.clear();
    homelist.addAll((ArrayList<Home>) results.values);
    notifyDataSetChanged();
}