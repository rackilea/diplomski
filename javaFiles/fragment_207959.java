public static void main(String[] args){

    int d = 5;
    tryToChange(d);

    System.out.println("tryToChange d = " + d);


}

public static void tryToChange (int d){

    d = d + 1;
    System.out.println("tryToChange d = " + d);
}