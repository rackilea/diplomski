public Map<Object, Map<Object, Object>> getTest() {
    return new HashMap<Object, Map<Object, Object>>() {
      @Override
      public Map<Object, Object> get(final Object test1) {
        return new HashMap<Object, Object>() {
          @Override
          public Object get(Object test2) {
            return getSomething(test1, test2);
          }
        };
      }
    };
  }

  private Object getSomething(Object test1, Object test2) {
    //TODO
  }