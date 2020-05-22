public static void main(String[] args) throws Exception
{   
    System.out.println("Main");
    try {
        good(); // doesn't throw an exception
    } catch (Exception e) { 
        System.out.println("Main catch");
        throw new RuntimeException("RE");
    }
    bad(); // execution goes from good() to here
}