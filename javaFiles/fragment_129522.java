ImageButton Ibutton = (ImageButton) findViewById(R.id.button_1);
Ibutton.setOnClickListener(this);      

ImageButton Ibutton2 = (ImageButton) findViewById(R.id.button_2);
Ibutton2.setOnClickListener(this);      


@Override
public void onClick(View v) {
switch(v.getId()){
    case R.id.button_1:
    // action to preform on button 1
        Toast.makeText(testActivity.this, "Button 1 pressed ", Toast.LENGTH_SHORT).show();
        break;
    case R.id.button_2:
    // action to preform on button 1
        Toast.makeText(testActivity.this, "Button 2 pressed ",     Toast.LENGTH_SHORT).show();
        break;
    }
}