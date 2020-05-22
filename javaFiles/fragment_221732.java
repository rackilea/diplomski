String user = "Melissa";
 int pin = 123456;
 int pin2;
 int MAX_INCORRECT_PIN_THRESHOLD = 2;
 int attempts = 0;

 // Prompt the user for input
 do {
     String pin2String = JOptionPane.showInputDialog("Enter PIN");
     pin2 = Integer.parseInt(pin2String);
     attempts++;
 } while(pin2 != pin && attempts < MAX_INCORRECT_PIN_THRESHOLD);

 if (pin2 == pin) {
     // Display
     JOptionPane.showMessageDialog(null, "User: "+ user);
 }