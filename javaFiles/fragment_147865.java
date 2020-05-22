public class PageBuilder {

Context mContext;
PageBuilder(Context mContext){
    this.mContext = mContext;
}

public void mainMenu() {
    LinearLayout ll = new LinearLayout(mContext);
    LinearLayout.LayoutParams llP = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    ll.setLayoutParams(llP);
    ll.setOrientation(LinearLayout.VERTICAL);
    LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

    Button btnOne = new Button(mContext.getApplicationContext());
    btnOne.setLayoutParams(btnParams);
    btnOne.setText("One");
    ll.addView(btnOne);

    Button btnTwo = new Button(mContext.getApplicationContext());
    btnTwo.setLayoutParams(btnParams);
    btnTwo.setText("Two");
    ll.addView(btnTwo);

    Button btnThree = new Button(mContext.getApplicationContext());
    btnThree.setLayoutParams(btnParams);
    btnThree.setText("Three");
    ll.addView(btnThree);
    Activity activity = (Activity)mContext;
    activity.setContentView(ll);
}}