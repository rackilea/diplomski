public static void main(String[] args){
    String s = "i=number j=number k=number u=number";
    System.out.println(s.matches("(([ijku]=)(?!.*\\2)number(?:\\s(?=\\w)|$)){4}"));
    s = "u=number j=number k=number i=number";
    System.out.println(s.matches("(([ijku]=)(?!.*\\2)number(?:\\s(?=\\w)|$)){4}"));
    s = "u=number j=number k=number u=number";
    System.out.println(s.matches("(([ijku]=)(?!.*\\2)number(?:\\s(?=\\w)|$)){4}"));
}