import java.util.Arrays;
import java.util.Optional;

public class EnumDemo {

    public enum MyEnum {
        A("Approved"),
        R("Reject New");

        private String status;

        private MyEnum(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public static MyEnum getEnumfromString(String text) {
            return Arrays.stream(values())
              .filter(v -> v.name().equalsIgnoreCase(text))
              .findFirst()
              .orElse(null);
        }

        public static String getStatusfromString(String text) {
            MyEnum found = Arrays.stream(values())
                  .filter(v -> v.name().equalsIgnoreCase(text))
                  .findFirst()
                  .orElse(null);
            return found != null ? found.getStatus() : "- Not found -";
        }

        public static Optional<MyEnum> getOptionalfromString(String text) {
            try {
                return Optional.of(MyEnum.valueOf(text));
            } catch (IllegalArgumentException|NullPointerException e) {
                return Optional.empty();
            }
        }
    }

    public static void doCalls(String searchString) {
        System.out.print("Call 1: ");
        MyEnum foundEnum = MyEnum.getEnumfromString(searchString);
        System.out.println(foundEnum != null ? foundEnum.getStatus() : "- Not found -");

        System.out.print("Call 2: ");
        System.out.println(MyEnum.getStatusfromString(searchString));

        System.out.println("Call 3 :");
        System.out.print(" A: ");
        Optional<MyEnum> foundOptional = MyEnum.getOptionalfromString(searchString);
        System.out.println(foundOptional.map(a -> a.getStatus()).orElse("- Not found -"));
        //or this, which only prints if the enum was found
        System.out.print(" B: ");
        foundOptional.ifPresent(a -> System.out.println(a.getStatus()));
    }

    public static void main(String[] args) {
        System.out.println("Existing enum: 'A'");
        doCalls("A");
        System.out.println("");
        System.out.println("Non-existing enum: 'B'");
        doCalls("B");
    }
}