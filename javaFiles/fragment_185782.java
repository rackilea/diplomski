public void onNumpress(View v){
        buttonFlash((Button) v);
        String value = getResources().getResourceEntryName(v.getId()).replace("btn", "");
        if (expression.equals("0")) {
            expression = "";
            Screen.setText("");
        }
        if (checkLength(Screen)) Screen.append(expostate ? getSuperscript(value) : value);
        expression += value;
        presentop = false;
    }