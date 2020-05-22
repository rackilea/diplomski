final String[] values = getResources().getStringArray(R.array.routeList);
ListAdapter routeAdapter = new CustomAdapter(this, values);

final ListView routeListView = (ListView) findViewById(R.id.routeListView);
routeListView.setAdapter(routeAdapter);

routeListView.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,     int position, long id) {

                String route = values[position];
                if (route.equals("1. Shark Bait - 5.9")) {

                    Intent intent = new Intent(MainActivity.this,     RouteDetails.class);
                    intent.putExtra("route", "Shark Bait");
                    startActivity(intent);
                }