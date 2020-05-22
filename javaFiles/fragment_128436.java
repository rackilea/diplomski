Button button = (Button) findViewById(R.id.button);
button.setOnClickListener(new OnClickListener() {
public void onClick(View v) {
Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.incrediblemachine.palpal");
startActivity(launchIntent);

}
});