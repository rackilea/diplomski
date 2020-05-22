strNum2 = String.valueOf(strNum1);
        String resultString = "";
        for (int count=0; count<strNum1.length();count++){
            chDigit = strNum2.charAt(count);
            aDigit = Character.getNumericValue(chDigit);
            totalNum += aDigit;
            if (aDigit > 0 && aDigit <= 9){
                System.out.print(aDigit + " ");
                resultString += aDigit + " ";
            }
        }
        JOptionPane.showMessageDialog(null, resultString);