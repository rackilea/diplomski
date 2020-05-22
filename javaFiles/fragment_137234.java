@Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if(v == plotButton) {
        double radius = Double.parseDouble(radius.getText().toString());
        Intent intent = new Intent(this, MapActivity.class);
        //something to write overhere
        Bundle b = new Bundle();
        b.putDouble("radius", radius);
        intent.putExtras(b);
        this.startActivity(intent);                     
        }
        else if(v == clearButton) {
            ((EditText)findViewById(R.id.editText1)).setText("");               
        }
    }
    .....