package com.mycompany.rns;

imports are listed here...

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent k = new Intent(this,MyService.class);
        startService(k);
    }
}