public class ABCGroup extends ActivityGroup{

public static ABCGroup group;
private ArrayList<View> history;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.history = new ArrayList<View>();
    group = this;

    View view = getLocalActivityManager().startActivity
                ("ParentActivity", 
                new Intent(this, ParentActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                .getDecorView();

    replaceView(view);
}

public void replaceView(View v) {
    // Adds the old one to history
    history.add(v);
    // Changes this Groups View to the new View.
    setContentView(v);
}

public void back() {  
    if(history.size() > 0) {  
        history.remove(history.size()-1);
        if(history.size()<=0){
            finish();
        }else{
            setContentView(history.get(history.size()-1));
        }
    }else {  
        finish();  
    }  
}

@Override  
public void onBackPressed() {  
    ABCGroup.group.back();
}

@Override
public boolean onKeyDown(int keyCode, KeyEvent event){
    if (keyCode == KeyEvent.KEYCODE_BACK){
        ABCGroup.group.back();
        return true;
    }
    return super.onKeyDown(keyCode, event);
}
}