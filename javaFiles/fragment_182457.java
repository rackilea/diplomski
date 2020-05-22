@XStreamAlias("error")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class Error {

   String message;
   int code;
}