@Override
    public void onClick(View view){

        final int addTm;
        try {
            String teaching = Tm.getText().toString();
            addTm = Integer.parseInt(teaching);
        } catch (NumberFormatException e) {
            addTm = 0;
        }

        // ...
    }