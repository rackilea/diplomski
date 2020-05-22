// Implement On Item click listener
gridView1.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Spacecraft spaceCraft = (Spacecraft)parent.getAdapter().getItem(position);
       Intent intent = new Intent(getActivity,FullscreenInfo.class);
       intent.putExtra("image_url",spaceCraft.getImageURL());
       startActivity(intent);

    }
});