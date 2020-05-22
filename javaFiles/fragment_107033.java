Properties data = Properties.create();
  // This loop also gets grand-children, and you can use more sophisticated css selectors
  for (Element e: $("form").find("input").elements()) {
    data.set($(e).attr("name"), $(e).val());
  }

  GQuery.post("/my_servlet", data, new Function(){
    public void f(){
      // Use getDataObjet in non snapshot versions
      String response = arguments(0);
    };
  });