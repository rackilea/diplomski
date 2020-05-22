try{
       if(validation == true){
            int numA = Integer.parseInt(aTextField.getText());
            int numB = Integer.parseInt(aTextField.getText());
            int sum = numA + numB;

            if(sum == 100){
                validation = true;
                System.out.println("success");
            } else{
                JOptionPane.showMessageDialog(createFrame, "A and B must add up to 100");
                validation = false;
            }
        }
    } catch (NumberFormatException n){
            JOptionPane.showMessageDialog(createFrame, "Only numbers should be entered into A and B");
            validation = false;
    }