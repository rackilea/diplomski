public static Data[] users = new Data[600];
public static int count = 0;
public String name;

public Data(String name) {
     this.name = name;
     Data.count++;
}