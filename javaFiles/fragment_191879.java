LayoutInflater vi; 
public MyPerformanceArrayAdapter(Activity a, int textViewResourceId,List<DefinitionObject> entries) {
super(a, textViewResourceId, entries);
this.entries = entries;
vi =(LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
}