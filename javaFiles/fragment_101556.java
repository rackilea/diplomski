String morse = vpis.getText().toString();
String text = "";
        for (int i=0; i<morse.length(); i++){
            if(morse.charAt(i) == 'a'){
                text+=".-";
            }else if (morse.charAt(i) == 'b'){
                text+="-...";
            }
     }
rezultat.setText(text);