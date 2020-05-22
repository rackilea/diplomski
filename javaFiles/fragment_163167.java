@Override
  public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

       // now get the checkbox view. Then set the checked status.
        CheckBox checkbox = (CheckBox) view.findViewById(R.id.check_box);
        checkBox.setChecked(!checkbox.isChecked());
  }