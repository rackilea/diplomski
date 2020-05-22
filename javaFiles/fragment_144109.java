Map<String, Strategy> strategies = new HashMap<String, Strategy>();
strategies.put("strategyName1", new SomeStrategy1());
strategies.put("strategyName2", new SomeStrategy2());
strategies.put("strategyName3", new SomeStrategy3());

// ...

strategies.get(s).execute();