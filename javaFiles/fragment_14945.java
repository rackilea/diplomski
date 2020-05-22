static ArrayList<HashMap<String, String>> results;
  .
  .
  .
    @Override
                public void onItemClick(AdapterView<?> parent, View view,
                        int position, long id) {

                    HashMap<String, String> hm = results.get(position);
                    String link = hm.get("link");
                    L.m(link);
                    if (!link.equals("")) {
                        //do what ever you like to do with link;
                        Intent browserIntent = new Intent(MainActivity.this, WebActivity.class);
                        browserIntent.putExtra("url",link);
                        startActivity(browserIntent);
                    }
                }