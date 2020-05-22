public void submit(String formSelector, List<String> params) {
    if (params.size() % 2 != 0) {
      throw new Exception("There must be an even number of params.");
    }

    Element form= $(formSelector).first();

    Set<String> newParams= Sets.newHashSet();
    for (int i=0; i < params.size(); i+= 2) {
      newParams.add(params.get(i));
    }

    List<String> allParams= Lists.newArrayList(params);
    for (Element field: form.select("input, select, textarea")) {
      String name= field.attr("name");
      if (name == null || newParams.contains(name)) continue;
      String type= field.attr("type").toLowerCase();
      if ("checkbox".equals(type) || "radio".equals(type)) {
        if (field.attr("checked") != null) {
          allParams.add(field.attr("name"));
          allParams.add(field.attr("value"));
        }
      }
      else if (! fieldTypesToIgnore.contains(type)) {
        allParams.add(field.attr("name"));
        allParams.add(field.val());
      }
    }

    String action= form.attr("abs:action");
    String method= form.attr("method").toLowerCase();
    // String encType= form.attr("enctype"); -- TODO

    if ("post".equals(method)) {
      post(action, allParams);
    }
    else {
      get(action, allParams);
    }
  }