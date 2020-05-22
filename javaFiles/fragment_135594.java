boolean moveon;
//...
onCreate() {
    moveon = false;
//...

Handler myh = new Handler();
Runnable myr = new Runnable() { 
    public void run() {
        Resources res = getResources();
        for(int i=0; i<3; i++){
            id = res.getIdentifier("txt"+Integer.toString(winners[i]), "id",
                    getApplicationContext().getPackageName());      
            TextView temp = (TextView)findViewById(id);
            temp.setBackgroundColor(Color.parseColor("#ffd700"));
            temp.getBackground().setAlpha(127);
            temp.invalidate();
        }
        moveon = true;
    }
};
myh.post(myr);
while(moveon == false){}