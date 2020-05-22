public class PhoneNumnberInUseException extends IllegalArgumentException implements Serializable{
    public PhoneNumnberInUseException(){
        super();
    }
    public PhoneNumnberInUseException(String msg) {
        super(msg);
    }
}