listView.setOnItemClickListener(new OnItemClickListener(){
    private Set<Integer> hasClickedSet = new HashSet<Integer>();
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){
        if (hasClickedSet.contains(position)){
            v.setBackgroundColor(Color.BLACK);
        } else {
            v.setBackgroundColor(Color.GREEN);
            hasClickedSet.add(position);
        }
}