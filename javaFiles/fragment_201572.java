OutputStream fos = new FileOutputStream("new_fake_students.json",false);
    JsonGenerator g = Json.createGenerator(fos);
    g.writeStartArray(); // start the array
    while (matcher.find())
    {
        String temp = matcher.group();
        String[] values = temp.split(",");
        if(values.length>=4)
        { 
          g.writeStartObject();
          g.write("id",values[0]);
          g.write("name",values[1]+values[2]);
          g.write("major",values[3]);
          g.writeEndObject(); // does g.writeEnd() even exists?
        }
    }
    g.writeEndArray(); // close that array