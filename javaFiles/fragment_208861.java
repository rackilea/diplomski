public void mergecheck(View v){
    View dialog_view = View.inflate(this, R.layout.mergetablepopup, null);

    ListView listView = (ListView)dialog_view.findViewById(R.id.tablelist);

    ArrayList<Mergetablelist> countryList = new ArrayList<Mergetablelist>();
    Mergetablelist country = new Mergetablelist("AFG","Table 100",false);
    countryList.add(country);
    country = new Mergetablelist("ALB","Tabel 101",true);
    countryList.add(country);
    country = new Mergetablelist("DZA","Tabel 102",false);
    countryList.add(country);
    country = new Mergetablelist("ASM","Tabel 103",true);
    countryList.add(country);
    country = new Mergetablelist("AND","Tabel 104",true);
    countryList.add(country);
    country = new Mergetablelist("AGO","Tabel 105",false);
    countryList.add(country);
    country = new Mergetablelist("AIA","Tabel 106",false);
    countryList.add(country);
    country = new Mergetablelist("AIA","Tabel 107",false);
    countryList.add(country);
    country = new Mergetablelist("AIA","Tabel 108",false);
    countryList.add(country);
    country = new Mergetablelist("AIA","Tabel 109",false);
    countryList.add(country);
    country = new Mergetablelist("AIA","Tabel 110",false);
    countryList.add(country);

    //create an ArrayAdaptar from the String Array


    dataAdapter = new MyCustomAdapter(this,
            R.layout.mergetablelist_elements, countryList);
    //ListView listView = (ListView) findViewById(R.id.tablelist);
    // Assign adapter to ListView
    listView.setAdapter(dataAdapter);

    new AlertDialog.Builder(this)
            .setView(dialog_view)
            .show();
}