@Override
protected FilterResults performFiltering(CharSequence constraint) {
     FilterResults results = new FilterResults();
    // We implement here the filter logic
    if (constraint == null || constraint.length() == 0) {
        // No filter implemented we return all the list
         results.values = yourList;
         results.count = yourList.size();
    }
    else {
    // We perform filtering operation
    List<Program> finalList = new ArrayList<Program>();
    //here think of something regarding the upper and lower cases.
    for (Program p : yourList) {            
        if(p.getCategories().
              contains(constraint.toString()))
         finalList.add(p);
    }

     results.values = finalList;
     results.count =  finalList.size();
   }
   return results;
}