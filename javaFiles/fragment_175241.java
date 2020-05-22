btn1.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                tracker.trackPageView("/Categories");  //Error:  "The import com.google.android.apps cannot be resolved to a type"
                Intent intent = new Intent(MainMenu.this, Categories.class);
                startActivity(intent);
            }
        });