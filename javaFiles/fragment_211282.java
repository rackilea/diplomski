TestObj predefined = ...
TestObj max =
        xmlstream.stream()
                 .map(xml -> xml.getName()) //returns a string
                 .map(s -> s.split("__"))
                 .map(a -> new TestObj(a[0], a[1]))
                 .filter(e -> e.aProperty().compareTo(predefined.aProperty()) > 0)
                 .findFirst()
                 .orElse(predefined);