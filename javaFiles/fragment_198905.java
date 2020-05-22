StringJoiner joiner = new StringJoiner(" "); // Use 'space' as the delimiter
joiner.add("watch") // watch 
      .add("on") // watch on 
      .add("youtube") // watch on youtube
      .add(":") // etc...
      .add("Mickey")
      .add("en")
      .add("de")
      .add("stomende")
      .add("drol");

return joiner.toString();