final listView lv=getListView();

 lv.setOnItemClickListener(new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, View view,
                            int position, long id) {
        // getting values from selected ListItem
        String name = ((TextView) view.findViewById(R.id.PostName))
                .getText().toString();
        String cost = ((TextView) view.findViewById(R.id.Location))
                .getText().toString();
        String description = ((TextView) view.findViewById(R.id.Salary))
                .getText().toString();
HashMap<String, String> info = new HashMap<String, String>();
        info=(HashMap<String, String>)lv.getAdapter().getItem(position);

        // Starting single contact activity
        Intent in = new Intent(getApplicationContext(),
                SingleContactActivity.class);

        in.putExtra(TAG_POSTNAME, name);
        in.putExtra(TAG_LOCATION, cost);
        in.putExtra(TAG_SALARY, description);    
        in.putExtra(RESPONSIBILITY,  info.get(TAG_RESPONSIBILITY));
        in.putExtra(TAG_COMPANY, info.get(TAG_COMPANY));
        in.putExtra(TAG_CONTACT, info.get(TAG_CONTACT));
    startActivity(in);