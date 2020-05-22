JSONStringer json = new JSONStringer();

    json.object();
    json.key("stuff").value("1")
            .key("name").value("2")
            .key("type_name").value("3")
            .key("type").value("4");
    json.endObject();

    //after calling the method which returns a jsonobject like above:
    JSONObject jo=new JSONObject(json.toString());
    jo.put("hi", "hi2");