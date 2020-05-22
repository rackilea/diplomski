boolean insert = myDb.update(
  <pass the id's value here>,
  editTitle.getText().toString(),
  editDescription.getText().toString(),
  editLocation.getText().toString()
);