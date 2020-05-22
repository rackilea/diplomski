map.keys().iterator(); // is the same as
map.inverse().values().iterator();

map.values().iterator(); // is the same as
map.inverse().keys().iterator();

map.entrySet().iterator(); // almost the same as
map.inverse().entrySet().iterator();