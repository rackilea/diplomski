v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // ListView Clicked item value
            String  itemValue = (String) lv.getItemAtPosition(position);

            // Show Alert
            Toast.makeText(getApplicationContext(), "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();

            switch( itemValue )
            {
                case "alfred":  Intent alfred = new Intent(telaPesquisa.this, alfred.class);
                    startActivity(alfred);
                    break;

                case "beth":  Intent beth = new Intent(telaPesquisa.this, beth.class);
                    startActivity(beth);
                    break;

                case "bill":  Intent bill = new Intent(telaPesquisa.this, bill.class);
                    startActivity(bill);
                    break;
        }
    });