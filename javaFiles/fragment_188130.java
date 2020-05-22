public void onDeleteClick(View v) {
    int i = Integer.parseInt((String)v.getTag());

    AlertDialog.Builder alert = new AlertDialog.Builder(AddressListActivity.this);
    alert.setTitle("Delete");
    alert.setMessage("Are you sure you want to delete?");
    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            Address address = _list.get(_currentPage*PANELS_PER_PAGE + i);
            _dbAdapter.deleteAddress(address.Id);

            _GetAddresses();

            dialog.dismiss();
        }
    });

    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
        }
    });

    alert.show();
}