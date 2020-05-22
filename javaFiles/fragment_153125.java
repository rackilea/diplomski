private void fillTable(View v, Cursor c) {

TableLayout ll = (TableLayout) v.findViewById(R.id.tableLayoutList);

View mTableRow = null;
int i = 0;
while(!c.isAfterLast()){
    i++;
    mTableRow = (TableRow) View.inflate(getActivity(), R.layout.mRowLayout, null);

     CheckBox cb = (CheckBox)mTableRow.findViewById(R.id.checkBoxServEmail);
     cb.setText( c.getString(c.getColumnIndex(Empleado.EMAIL)));


     mTableRow.setTag(i);

    //add TableRows to TableLayout
    ll.addView(mTableRow);

    c.moveToNext();
}
}