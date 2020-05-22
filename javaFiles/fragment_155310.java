public Weird(int num) 
{       
    n = num;
}

public String EvenOrOdd() 
{
    int check = n % 2;
    if (check == 1 || (check == 0 && n >= 6 && n <= 20)) {
        return "Weird";
    }else{
        return "Not Weird";
    }
}


public static void main(String[] args) 
{
    Weird w = new Weird(32);
    Weird a = new Weird(21);
    System.out.println("This number is " + w.EvenOrOdd());
    System.out.println("This number is " + a.EvenOrOdd());

}