private JsonObject buildJson(JsonObject object){
    System.out.println("generating json for "+this.name);
    object.addProperty("name", this.name);
    JsonArray allChildren = new JsonArray();
    JsonObject aChild;
    for(Map.Entry<String,Dir> entry:dirs.entrySet()){
        aChild=new JsonObject();
        Dir thisDir = entry.getValue();            
        thisDir.buildJson(aChild);
        allChildren.add(aChild);
    }
    JsonArray thisFiles = (JsonArray) new Gson().toJsonTree( this.files.values());
    allChildren.addAll(thisFiles);
    if (allChildren.size() == 0)
        allChildren=null;
    object.add("children",allChildren);
    System.out.println(object);
    return object;
}