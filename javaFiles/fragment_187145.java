String result = "";
for (int i = 0; i < encrypt.length(); i++) {
        char c = encrypt.charAt(i);
        if (Character.isLetter(c)) {
            c -= shift;
            if(c < 'A'){
                c = (char) (((int) c + (int) ('A')) % 26 + (int) ('A'));
            }else{
                c = (char) (((int) c - (int) ('A')) % 26 + (int) ('A'));
            }


        }
result += String.valueOf(c);
    }
JOptionPane.showMessageDialog(null, result);