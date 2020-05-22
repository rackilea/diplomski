Map<String, EnumResolver> resolverMap = new ConcurrentHashMap<>();
resolverMap.put("com.abc.MobileEnum", new EnumResolver("com.abc.MobileEnum"));
resolverMap.put("com.abc.SignalEnum", new EnumResolver("com.abc.SignalEnum"));
// etc

Information inf = new Information();
inf.setType("com.abc.SignalsEnum");
inf.setValue("1");

SignalEnum red = (SignalEnum) resolverMap.get(inf.getType()).resolve(inf.getValue());