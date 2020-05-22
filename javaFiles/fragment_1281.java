public class Foo {
    String fooStr;
    List<Bar> barList;
    ...
}

public class Bar {
    String barStr;
}

public class Target {
    String fooStr;
    Map<String, Bar> barMap;   
}


public class TestCustomConverter implements CustomConverter {

  public Object convert(Object destination, Object source, Class destClass, Class sourceClass) {
    if (source == null) {
      return null;
    }
    if (source instanceof Foo) {
      Map<Bar> dest = null;
      // check to see if the object already exists
      if (destination == null) {
        dest = new Target();
      } else {
        dest = (Target) destination;
      }
      ((Target) dest).setFooStr(source.getFooStr());
      for(Bar : source.getBarList()) {
          ((Target) dest).getBarMap().put(bar.getBarStr(), bar);
      }
      return dest;
    } else if (source instanceof Target) {
      Foo dest = null;
      // check to see if the object already exists
      if (destination == null) {
        dest = new Foo ();
      } else {
        dest = (Foo) destination;
      }
      dest.getFoos().addAll(((Target)source).getBarMap().values());
      dest.setFooStr(((Target)source).getFooStr()):
      return dest;
    } else {
      throw new MappingException("Converter TestCustomConverter used incorrectly. Arguments passed in were:"
          + destination + " and " + source);
    }
  }