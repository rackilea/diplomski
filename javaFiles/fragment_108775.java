int [][] a = new int [100][];
n=1;//now 1, but this value entered in EditText
...     
        if (edit_1.getText().length() > 0) {
            a[n+1] = new int[edit_1.getText().length()];
            for (int ii = 0; ii < a.length; ii++) {
                a[n+1][ii] = Integer.parseInt(String.valueOf(edit_1.getText().charAt(ii)));
            }
        }