TestObj predefined = ...
Optional<TestObj> max =
             xmlstream.stream()
                      .map(xml -> xml.getName()) 
                      .map(s -> s.split("_"))
                      .map(a -> new TestObj(a[0], a[1]))
                      .filter(e -> e.aProperty().compareTo(predefined.aProperty()) < 0)
                      .max(Comparator.comparing(TestObj::aProperty));