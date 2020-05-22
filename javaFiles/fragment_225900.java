//Mac-Makkhdyn:~ Makkhdyn$ cat A.java
public class A{
public static void main(String... args){
System.out.println("lol");
}
}
//Mac-Makkhdyn:~ Makkhdyn$ cat manifest 
Main-Class: A
//Mac-Makkhdyn:~ Makkhdyn$ javac A.java
//Mac-Makkhdyn:~ Makkhdyn$ jar cvfm A.jar manifest A.class 
added manifest
adding: A.class(in = 399) (out= 278)(deflated 30%)
//Mac-Makkhdyn:~ Makkhdyn$ java -jar A.jar
lol