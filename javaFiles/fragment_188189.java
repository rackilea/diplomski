public void onItemClick(AdapterView parent, View v, int position, long id) {
    String value = uta[position].getValue();
    switch(value){
        case "value1":
            Intent intent = new Intent(this, activity1.class); startActivity(intent);
        break;

        case "value2":
            Intent intent = new Intent(this, activity2.class); startActivity(intent);
        break;

        case "value3":
            Intent intent = new Intent(this, activity3.class); startActivity(intent);
        break;
    }
}