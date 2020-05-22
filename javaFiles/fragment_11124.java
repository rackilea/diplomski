public <T> T getSetting(String settingName, Function<Object, T> cast) {
    final Object obj = settings.getJsonObject(settingName).getValue("value");
    return obj == null ? null : cast.apply(obj);
}
...
Integer x = getSetting("mysetting", o -> Integer.parseInt(o.toString()));