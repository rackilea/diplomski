@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String filter = (String) spinner.getAdapter().getItem(position);
    // update your peolesListAll according to the selected filter (with loop or anything else)
    alertAllCustomAdapter.setData(peolesListAll) // write setData(List<People> data)
    alertAllCustomAdapter.notifyDataSetChanged();
}