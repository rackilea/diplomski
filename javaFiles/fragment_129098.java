boolean first = true;
for (Map.Entry<String, String> entry : listClientSize.entrySet()) {
    String name = entry.getKey().toString();;
    String size = entry.getValue();
    if (first)
        first = false;
    else
        out.println("},");
    out.println("{");
    out.println("name : \""+name+"\",");
    out.println("y:"+size);
}
out.println("}");