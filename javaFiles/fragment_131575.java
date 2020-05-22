listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        switch (i){
            case 0:
                Intent intent = new Intent(MainActivity.this, TabbedActivity.class);
                intent.putExtra("YOUR_TEXT", "Text One");
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(MainActivity.this, TabbedActivity.class);
                intent1.putExtra("YOUR_TEXT", "Text Two");
                startActivity(intent1);
                break;
        }

    }
});