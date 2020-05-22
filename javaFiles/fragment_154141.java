import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
 //import org.json.simple.JSONObject;


public class TestObject 
{
   private double[] values;
   private int length;
   private int anotherVariable;
   private boolean someBool;
   private String someString;

   //getters, setters

   public String toJSON() {
       JSONObject obj=new JSONObject();
       obj.put("values",new Double(this.values));
       obj.put("length",new Integer(this.length));
       obj.put("bool_val",new Boolean(this.SomeBool));
       obj.put("string_key",this.someString);
       StringWriter out = new StringWriter();
       obj.writeJSONString(out);
       return out.toString();
   }

   public void writeObject(){
          Writer writer = new BufferedWriter(
                              new OutputStreamWriter(
                                  new FileOutputStream("anObject.json"), "utf-8")
                              )
                           )

          writer.write(this.toJSON());
   }

   public static void setObject(){
       values = 100.134;
       length = 12;
       anotherVariable = 15;
       someString = "spam";
   }
 }