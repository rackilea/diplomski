void onCreate(Bundle s){
    super.onCreate(s);
    checkAndroidData(new Listener<Boolean>(){
        public void on(Boolean result){
                Toast.makeText(result, Toast.LENGHT_LONG).show();
        }
    });
}