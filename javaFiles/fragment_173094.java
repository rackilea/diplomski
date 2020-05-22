// instantiate the map
Map<String, Button> map = new HashMap<String, Button>();
// fill the map
map.put("btn0", new Button());
// later on, retrieve the button given its name
map.get("btn" + i).setOnClickListener(this);