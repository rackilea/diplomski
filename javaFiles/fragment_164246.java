Map<String, Object> par = new HashMap<String, Object>();
par.put("ingredients", "someIngredientValue"});
ParseCloud.callFunctionInBackground("getFoo", par, new FunctionCallback() {
  @Override
  public void done(Object o, Throwable throwable) {
    Log.v("28", "" + o);
    Log.v("27", "" + throwable.getMessage());
    for (Object obj : (ArrayList)o) {
      Log.v("29",""+((ParseObject) obj).get("title"));
    }
  } 
//the rest of your code ...