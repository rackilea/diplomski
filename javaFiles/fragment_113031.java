@Cached(key="page1")
  public static Result page1() {
      java.util.Date d = Calendar.getInstance().getTime();
      return ok(page.render(d.toString()));
  }

  public static Result page2() {
      Result result = (Result) Cache.get("page2");
      if ( result == null ) {
          java.util.Date d = Calendar.getInstance().getTime();
          result = ok(page.render(d.toString()));
          Cache.set("page2", result);
      }   
      return result;
  }