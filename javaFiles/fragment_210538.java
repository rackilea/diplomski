import static org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES;

import org.codehaus.jackson.map.ObjectMapper;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    BaseClass base = new BaseClass();
    A a = new A();
    B b = new B();
    C c = new C();

    ObjectMapper mapper = new ObjectMapper();

    String baseJson = mapper.writeValueAsString(base);
    System.out.println(baseJson); // {"baseName":"base name"}
    String aJson = mapper.writeValueAsString(a);
    System.out.println(aJson); // {"baseName":"base name","aName":"a name"}
    String bJson = mapper.writeValueAsString(b);
    System.out.println(bJson); // {"baseName":"base name","bName":"b name"}
    String cJson = mapper.writeValueAsString(c);
    System.out.println(cJson); // {"baseName":"base name","cName":"c name"}

    BaseClass baseCopy = mapper.readValue(baseJson, BaseClass.class);
    System.out.println(baseCopy); // baseName: base name

    // BaseClass aCopy = mapper.readValue(aJson, BaseClass.class);
    // throws UnrecognizedPropertyException: 
    // Unrecognized field "aName", not marked as ignorable
    // because the JSON contains elements for which no Java field
    // to bind to was provided.

    // Need to let Jackson know that not all JSON elements must be bound.
    // To resolve this, the class can be annotated with 
    // @JsonIgnoreProperties(ignoreUnknown=true) or the ObjectMapper can be
    // directly configured to not FAIL_ON_UNKNOWN_PROPERTIES
    mapper = new ObjectMapper();
    mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

    BaseClass aCopy = mapper.readValue(aJson, BaseClass.class);
    System.out.println(aCopy); // baseName: base name
    BaseClass bCopy = mapper.readValue(bJson, BaseClass.class);
    System.out.println(bCopy); // baseName: base name
    BaseClass cCopy = mapper.readValue(cJson, BaseClass.class);
    System.out.println(cCopy); // baseName: base name
  }
}

class BaseClass
{
  public String baseName = "base name";
  @Override public String toString() {return "baseName: " + baseName;}
}

class A extends BaseClass
{
  public String aName = "a name";
  @Override public String toString() {return super.toString() + ", aName: " + aName;}
}

class B extends BaseClass
{
  public String bName = "b name";
  @Override public String toString() {return super.toString() + ", bName: " + bName;}
}

class C extends BaseClass
{
  public String cName = "c name";
  @Override public String toString() {return super.toString() + ", cName: " + cName;}
}