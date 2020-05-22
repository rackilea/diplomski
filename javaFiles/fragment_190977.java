mListView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(context, ActivityLocalReps.class);
        intent.putExtras("StateName", data.get(position).stateName);
        context.startActivity(intent);
    }
});