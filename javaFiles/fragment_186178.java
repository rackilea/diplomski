$ java -version 
java version "1.7.0"
Java(TM) SE Runtime Environment (build 1.7.0-b147)
Java HotSpot(TM) Server VM (build 21.0-b17, mixed mode)
$ javac -version
javac 1.7.0
$ javac MyDataSource.java 
MyDataSource.java:7: error: MyDataSource is not abstract and does not override abstract method getParentLogger() in CommonDataSource
public class MyDataSource implements DataSource {
       ^
1 error