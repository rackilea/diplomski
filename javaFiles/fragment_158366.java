public void OnButtonClick(View ver) {
        EditText et1 = findViewById(R.id.et1);
        EditText et2 = findViewById(R.id.et2);
        TextView tv1 = findViewById(R.id.tv1);
        float num1;
        float num2;
        try
        {   

            num1 = Float.parseFloat(et1.getText().toString());
            num2 = Float.parseFloat(et2.getText().toString());
            float sum = num1 + num2;
            tv1.setText(String.valueOf(sum));
            et1.setError("Ok"); 

        }catch(NullPointerException e){ 

            et1.setError("Error");
        }   

    }