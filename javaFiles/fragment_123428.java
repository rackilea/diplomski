public JSONStringer build() {
    JSONStringer json = new JSONStringer();

    json.object();
    json.key("stuff").value("1")
            .key("name").value("2")
            .key("type_name").value("3")
            .key("type").value("4");
    return json ;
}
//in the other place when calling above method, say:
    JSONStringer json=build();
    json.key("hi").value("hi2");
    json.endObject();
    System.out.println(json.toString());