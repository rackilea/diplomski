listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ReportInformation reportInformation = arrayAdapter.getItem(i);
        Intent intent = new Intent(list_view.this, ProgressReports.class);
        intent.putExtra("object", reportInformation);
        startActivity(intent);
    }
});