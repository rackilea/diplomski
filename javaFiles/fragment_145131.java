import java.util.Arrays;
import java.util.function.Function;

enum Brand {

   COLA("cola", "CL8935"),
   BREAD("bread", "BR2810"),
   SNICKERS("snickers", "SN4423");

   private final String brand;

   private final String code;

   Brand(String brand, String code) {
      this.brand = brand;
      this.code = code;
   }

   public static Brand findBy(String value, Function<Brand, String> extractor) {
      return Arrays.stream(Brand.values())
            .filter(brand -> extractor.apply(brand).equalsIgnoreCase(value))
            .findFirst()
            .orElse("Either a default or throw exception here");
   }

   public String getBrand() {
      return brand;
   }

   public String getCode() {
      return code;
   }

}