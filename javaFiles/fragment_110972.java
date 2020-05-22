lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ...

        String data = ((ExerciseDAO)parent.getAdapter().getItem(position)).getTitle() ;

        ...
    }
});