TestObj predefined = ...

TestObj max = 
       xmlstream.stream()
                .map(xml -> xml.getName()) //returns a string
                .map(s -> s.split("__"))
                .map(a -> new TestObj(a[0], a[1]))
                .reduce(predifined, (e, a) -> 
                      e.aProperty().compareTo(a.aProperty()) >= 0 ? e : a);