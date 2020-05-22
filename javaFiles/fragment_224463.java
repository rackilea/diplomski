@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    ...

    Intent result = new Intent();
    result.putExtra("ArrivalListViewClickedValue", ArrivalListViewClickedValue);
    setResult(Activity.RESULT_OK, result);
    finish();
}