public class MyClass1 implements Serializable {
 some properties ...
 private  byte[] a01_14_01_content;

 @javax.beans.Transient //not @Transient
 public byte[] getA01_14_01_content() {
 return a01_14_01_content;
 } 
//getters and setters ...
}