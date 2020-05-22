Map<String, Class<? extends Animal>> map = new HashMap...
map.put("Goat", Goat.class);

//...
if ( map.get("Goat").isInstance(a) ) {
   a.update();
}