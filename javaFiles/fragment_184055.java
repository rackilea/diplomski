if (set == null) {

    notes.add("Example note");

} else {

    notes = new ArrayList(set);
    // suggestion use Log.d("test", set.toString()); since d -> debug, i-> 
   // information
   Log.i("test", set.toString());
}