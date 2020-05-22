public void addListenerOnButtonNews() {
button.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View arg0) {
    Intent intent = new Intent(getApplicationContext(), NewActivity.class);
    startActivity(intent);   

}
});
}

public void addListenerOnButtonGPS() {
button1.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View arg0) {
Intent intent = new Intent(getApplicationContext(), MainActivity.class);
startActivity(intent);   

}});  
}