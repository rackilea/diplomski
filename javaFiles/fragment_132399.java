JsonArray _array = new JsonArray()

for(i = 0; i< _arraylist.size(); i++){
JsonObject obj = new JsonObject();

obj.put(_array.list.get(i).getValue);

_array.put(obj);
}

}