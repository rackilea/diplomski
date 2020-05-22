listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        switch (i){
            case 0:
                Intent intent = new Intent(MainActivity.this, TabbedActivity.class);
                intent.putExtra("OPIS", "Item1 :: Text for Fragment OPIS");
                intent.putExtra("SIMPTOMI", "Item1 :: Text for Fragment SIMPTOMI");
                intent.putExtra("UZROCI", "Item1 :: Text for Fragment UZROCI");
                intent.putExtra("LIJECENJE", "Item1 :: Text for Fragment LIJECENJE");
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(MainActivity.this, TabbedActivity.class);
                intent1.putExtra("OPIS", "Item2 :: Text for Fragment OPIS");
                intent1.putExtra("SIMPTOMI", "Item2 :: Text for Fragment SIMPTOMI");
                intent1.putExtra("UZROCI", "Item2 :: Text for Fragment UZROCI");
                intent1.putExtra("LIJECENJE", "Item2 :: Text for Fragment LIJECENJE");
                startActivity(intent1);
                break;
        }

    }
});