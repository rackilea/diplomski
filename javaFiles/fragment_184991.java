public class GsonEnumParsinException extends RuntimeException {

    String notFoundEnumValue;
    String enumName;
    String fieldName;

    public GsonEnumParsinException(String notFoundEnumValue, String enumName) {
      this.notFoundEnumValue = notFoundEnumValue;
      this.enumName = enumName;
    }



    @Override
    public String toString() {
    return "GsonEnumParsinException [notFoundEnumValue="
        + notFoundEnumValue + ", enumName=" + enumName + "]";
    }



    public String getNotFoundEnumValue() {
        return notFoundEnumValue;
    }

    @Override
    public String getMessage() {
    return "Cannot found " + notFoundEnumValue  + " for enum " + enumName;
    }


}