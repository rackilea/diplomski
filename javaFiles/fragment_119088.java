private JdbcTemplate temp;

public void storeData(CustomObject customObject) {

    String sql = "INSERT INTO FooBar VALUES(" + customObject.id + ",\'"+  customObject.name +"\');";

    temp.update(sql);
}


@PostMapping(value = "/foo")
private void storeData(@RequestBody CustomObject[] customObjects) {
     // Save each record individually
      customObjects.forEach { customObject -> 
      tool.storeData(customObjects);
    }
}