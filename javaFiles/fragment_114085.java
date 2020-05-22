public class DataTypeUtil {

public static DataType fromString(String value) {
    return DataType.valueOf(value.toUpperCase()); // should check for null or blank
   }
}