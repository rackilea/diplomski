@Entity(value = "car")
@Indexes(@Index(fields = { @Field("manufacturer"), @Field("model"), @Field("year") }, options = @IndexOptions(unique = true)))
public class Car {
   public String manufacturer;
   public String model;
   public String year;
   public Double price;
}