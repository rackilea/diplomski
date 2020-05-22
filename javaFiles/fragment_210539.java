import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonSubTypes.Type;
import org.codehaus.jackson.annotate.JsonTypeInfo;
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
    System.out.println(baseJson); // {"type":"BaseClass","baseName":"base name"}
    String aJson = mapper.writeValueAsString(a);
    System.out.println(aJson); // {"type":"a","baseName":"base name","aName":"a name"}
    String bJson = mapper.writeValueAsString(b);
    System.out.println(bJson); // {"type":"b","baseName":"base name","bName":"b name"}
    String cJson = mapper.writeValueAsString(c);
    System.out.println(cJson); // {"type":"c","baseName":"base name","cName":"c name"}

    BaseClass baseCopy = mapper.readValue(baseJson, BaseClass.class);
    System.out.println(baseCopy); // baseName: base name
    BaseClass aCopy = mapper.readValue(aJson, BaseClass.class);
    System.out.println(aCopy); // baseName: base name, aName: a name
    BaseClass bCopy = mapper.readValue(bJson, BaseClass.class);
    System.out.println(bCopy); // baseName: base name, bName: b name
    BaseClass cCopy = mapper.readValue(cJson, BaseClass.class);
    System.out.println(cCopy); // baseName: base name, cName: c name
  }
}

@JsonTypeInfo(  
    use = JsonTypeInfo.Id.NAME,  
    include = JsonTypeInfo.As.PROPERTY,  
    property = "type")  
@JsonSubTypes({  
    @Type(value = A.class, name = "a"),  
    @Type(value = B.class, name = "b"),  
    @Type(value = C.class, name = "c") }) 
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