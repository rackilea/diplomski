// problem is here. "set" object is null.
 Log.i("test", set.toString());

if (set == null) {

    notes.add("Example note");

} else {

    notes = new ArrayList(set);

}