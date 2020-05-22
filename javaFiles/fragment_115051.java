@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class A {
    public static final Type UNMARSHALLER_TYPE = new TypeToken<A>(){}.getType();

   @SerializedName("id")
   String id;

   @SerializedName("name")
   String name;

   @SerializedName("is_enabled")
   boolean isEnabled;
}