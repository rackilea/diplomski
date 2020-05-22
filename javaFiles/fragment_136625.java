listView.setOnItemClickListener(
        new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           //     final String selected = (String) parent.getSelectedItem();
                Intent i = new Intent(getActivity(), Pop.class);
             //this would put your name into a intent extra
                i.putextra("name", arritems.get(position);

              //  i.putExtra("name", selected);
             //   Toast.makeText(getActivity(), selected, Toast.LENGTH_LONG).show();
                startActivity (i);
            }
        }