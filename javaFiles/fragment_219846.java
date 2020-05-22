gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String result = imagePaths.get(position);
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", result);
        setResult(showImages.RESULT_OK, returnIntent);
        finish();
    }
});