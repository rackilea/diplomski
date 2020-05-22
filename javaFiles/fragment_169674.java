String[] from = new String[]{ "lugar" };
int[] to = new int[]{ R.id.nombre };

ListAdapter adapter = new SimpleAdapter(MainActivity.this, oslist,
                                R.layout.list_item,
                                from, to);