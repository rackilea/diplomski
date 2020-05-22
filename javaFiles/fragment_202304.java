public class ValidateRegisterInputController {

    public boolean validateInputHandle(UserDataObject user1){
    ValidateInput validateinput = new ValidateInput();
    boolean check = true;

    if (!validateinput.validateUsername(user1.getUsername())) {
        check = false;
        BanUserGUI bangui = createBanUserGui();
        bangui.displayBanGUI();
    }

    return check;
   }

   BanUserGUI createBanUserGui()
   {
     return new BanUserGUI();
   }
}