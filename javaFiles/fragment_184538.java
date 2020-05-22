public class Nav extends Activity { 

  @Override 
  public void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.activity_nav); 

    navButton("nav1", MainActivity.class); 
    navButton("nav2", SQLite.class); 
} 

@Override 
public boolean onCreateOptionsMenu(Menu menu) { 
    getMenuInflater().inflate(R.menu.activity_nav, menu); 
    return true; 
} 

private void navButton(String buttonId, Class aName){ 
    String bId = buttonId; 
    // aName now passed in so doesn't need to be looked up
    ... etc ...
} 
}