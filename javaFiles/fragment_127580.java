protected FilterResults performFiltering(CharSequence constraint) {
   ArrayList<Note> tempList=new ArrayList<Note>();
   FilterResults results = new FilterResults();
   if (constraint != null && objects != null) {
      for(Note singleNote : objects) {
         if( singleNote.getTitle().contains(constraint)
           tempList.add(singleNote);
      }
      results.values = tempList;
      results.count = tempList.size();
   }

   return results;
}