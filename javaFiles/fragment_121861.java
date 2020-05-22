public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    Toast.makeText(this, planets[position] + " was selected", Toast.LENGTH_LONG).show();
    selectItem(position);
    selectItem2(position);
}

public void selectItem2 (int position) {

    switch (position) {
        case 0:
            Intent intent = new Intent(MainActivity .this,    physical_fragment.class);
            startActivityForResult(intent, 0);
            break;
    }
}