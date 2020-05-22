public static void main (String[] args) throws java.lang.Exception
{
    System.out.println(validateAddress("Test C\\O good:product"));
}
public static boolean validateAddress(String address) { 
    return address.matches("^[a-zA-Z0-9~`!@#$%^&*()_+={|}:;'<,>?\\\\ /\"\t\n\\[\\] .-]*$");
}