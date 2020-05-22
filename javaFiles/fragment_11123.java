public <T> T getSetting(String settingName, Class<T> clazz) {
    final Object obj = settings.getJsonObject(settingName).getValue("value");
    if (obj == null)
       return null;
    else if (!clazz.isInstance(obj))
      throw new IllegalArgumentException(String.format("wrong setting class; was expecting %s but found %s", clazz.getSimpleName(), obj.getClass().getName());
    else {
       return clazz.cast(obj);
    }
}
...
Integer x = getSetting("mysetting", Integer.class);