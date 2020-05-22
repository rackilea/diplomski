@Override
public void onItemSelected(AdapterView<?> parent, View v, int position,
        long id) {
    // TODO Auto-generated method stub
    switch (position) {
    case R.id.spinner1:
        spinner1.setSelection(position);
         selstate1 = (String) spinner1.getSelectedItem();
        break;
    case R.id.spinner2:
        spinner2.setSelection(position);
         selstate2 = (String) spinner2.getSelectedItem();
        break;