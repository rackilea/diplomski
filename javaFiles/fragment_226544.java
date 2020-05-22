Item item1 = new Item(1);
        item1.setOnClickListener(new ItemListAdapter.ClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "It works", Toast.LENGTH_SHORT).show();
            }
        });
        Item item2 = new Item(2, new ItemListAdapter.ClickListener() {
            @Override
            public void onClick() {

            }
        });