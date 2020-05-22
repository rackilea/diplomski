public static boolean validate(String num){

    try {
        int convertedNum = Integer.parseInt(num);
        if(convertedNum < 0 || convertedNum > 100){
            return false;
        }else{
            return true;
        }
    }catch ( NumberFormatException e){
        return false;
    }
}

for(int i=0; i<6;i++){

            inputNumbers[i] = JOptionPane.showInputDialog("Enter "+charNums[i]+" number from 1 to 100");
            while(!validate(inputNumbers[i])){
                if(inputNumbers[i] == null){
                    int stopGame = JOptionPane.showConfirmDialog(null,"Do you wish to cancel the game? All progress will be lost","",JOptionPane.YES_NO_OPTION);
                    if(stopGame == JOptionPane.YES_OPTION){
                        System.exit(0);
                    }
                }
                JOptionPane.showMessageDialog(null,"Invalid Number! try Again","ERROR",JOptionPane.ERROR_MESSAGE);
                inputNumbers[i] = JOptionPane.showInputDialog("Enter "+charNums[i]+" number from 1 to 100");
            }

            ////check for duplicate entries from user
            for (int k=0; k<i; k++)  {    
                while (k!=i && Integer.parseInt(inputNumbers[k]) == Integer.parseInt(inputNumbers[i]))  {
                    JOptionPane.showMessageDialog(null,"Duplicate Entry! try again","ERROR",JOptionPane.ERROR_MESSAGE);
                    inputNumbers[i] = JOptionPane.showInputDialog("Enter "+charNums[i]+" number from 1 to 100");
                }
            }

            //convert string to int
            userNumbers[i] = Integer.parseInt(inputNumbers[i]);
        }