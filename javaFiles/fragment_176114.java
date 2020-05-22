public class Demo {

    private final int passwordAttempts = 3;
    private int countAttempts = 0;
    private String password;
    private int digitCounter = 0;

    public Demo() {
        init();
    }

    public static void main(String[] args) {
        new Demo();
    }

    private String checkPassword(String pass) {
        if (pass.length() >= 8) {
            if (StringUtils.isAlphanumeric(pass)) {
                char[] toCharArray = pass.toCharArray();
                for (int i = 0; i < toCharArray.length; i++) {
                    char check = toCharArray[i];
                    if(Character.isDigit(check)){
                        digitCounter++;
                    }
                }
                if (digitCounter >= 1) {
                    return "success";
                }else{
                    return "digit";
                }
            }else{
                return "alphanumeric";
            }
        }else{
            return "length";
        }
    }

    private void init() {
        while (countAttempts < passwordAttempts) {
           password = JOptionPane.showInputDialog("Please Enter the Password");
           digitCounter = 0;
           String passwordResult = checkPassword(password);
           if (passwordResult.equals("success")) {
              JOptionPane.showInputDialog("yes you entered correct password...");
           } else if(passwordResult.equals("length")){
              JOptionPane.showInputDialog("password must contain atleast 8 characters...");
           }else if(passwordResult.equals("alphanumeric")){
              JOptionPane.showInputDialog("only alphanumeric password accept...");
           }else if(passwordResult.equals("digit")){
              JOptionPane.showInputDialog("password must contain atleast two digits...");
           }
          countAttempts++;
        }
    }
}