import java.io.Serializable;
 import javax.xml.bind.annotation.XmlRootElement;

 @XmlRootElement(name = "userMsg")
 public class UserMessage implements Serializable {

  public  enum UserCodes { SUCCESS, DATA_ALREADY_EXIST, DATA_WRONG_FORMAT };

 private enum userCode ;
 private String userMsg ;

 public UserMessage(){
 userCode = UserCodes.SUCCESS; //DEFAULT
 userMsg =  "Request successful";
 }

 public UserCodes getUserCode(){
return userCode;
}
public void setUserCode(UserCodes code){
 userCode = code;
}
public String getUserMsg(){
return userMsg;
}
 public void setUserMsg(String msg){
 userMsg = msg;
 }
 }