public class main {

public static void main(String[] args) {
    Scanner input=new Scanner(System.in);
    System.out.println("Wil je je wachtwoord resetten? Ja of nee");
    String pass=input.next();
    input.close();
    checkPassword(pass);
}

public static void checkPassword(String pass){
    if("Ja".equalsIgnoreCase(pass)) {
        System.out.println(generatePassword(28));
    } else{
        System.out.println("Okee, volgende keer beter!");
    }
}

static char[] generatePassword(int length) {
    System.out.println("Nieuw wachtwoord: ");
    String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvw";
    String nummers="0123456789";
    String raarTeken="!@#$%^&*)(}{[]<>?:;";

    String pwd=letters+nummers+raarTeken;
    Random r=new Random();
    char[] newPass=new char[length];

    for(int i=0; i<length; i++) {
        newPass[i]=pwd.charAt(r.nextInt(pwd.length()));
    }
    return newPass; 
}
}