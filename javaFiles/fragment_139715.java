listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String mcanvasid  = restCanvasList.get(position).get("mcanvasid"); // Here you get the mcanvasid

            }
        });