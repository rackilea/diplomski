public class HelloWorld {
public static void main(String[] args) {
System.out.println("Hello World");

String[][]nameAdress={{"karn dhillon", "vinny dhillon"},{"new house","old house"}};
meth(nameAdress);
}

public static void meth(String[][] name){
    for(String[] element: name){
        for(String field: element){
            System.out.println(field);
}
}
}
}