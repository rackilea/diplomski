1. android:onClick="Alpha" in xml  
2. 
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
}
3.public void Alpha(View v){
Intent intent = new Intent(this,Alphabet.class);
startActivity(intent);
}