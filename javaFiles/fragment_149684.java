@JsonFormat(shape=JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "name", "age" }) // or use "alphabetic"
public class POJO {
   public String name;
   public int age;
}