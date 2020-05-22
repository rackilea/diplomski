@Override
public boolean onContextItemSelected(MenuItem item) {

    getData() // GET THE DATA

    switch (item.getItemId()) {
        case R.id.item1:
            result = fNum * sNum;
            text.setText(String.valueOf(result));
            return true;
        .
        .
        .
    return super.onContextItemSelected(item);
}