public class Otherclass extend AppCompatActivity{

    Button example = (Button)findViewById(R.id.option_language);
            example.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    App.setIsChecked(true);
                }
            });
}

public class App extends Application {
    public static boolean isChecked = false;
    @Override
    public void onCreate() {
        super.onCreate();
        ToDo();
    }

    public void setIsChecked(boolean isChecked) {
            this.isChecked = isChecked;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toDo();
    }

    public void toDo() {
        if(isChecked) {
           // To do something.
            }
        }
    }
}