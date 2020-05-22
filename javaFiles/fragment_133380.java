JsonObject jsonObject = new JsonParser().parse(st).getAsJsonObject();
JsonElement el = jsonObject.get("error");
if (el != null && !el.isJsonNull()){
        System.out.println (" not null");           
}else{
        System.out.println (" is null");
}