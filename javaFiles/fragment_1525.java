gridView.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View v,
            int position, long id) {

        switch (position) {
            case 0:
                //Depending on the position, define your intent
                intent = new Intent(this, NewActivity.class);
                startActivity(intent)
                break;
            //further cases
        }

    }
});