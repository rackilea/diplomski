public class MainActivity extends Activity implements AnimationListener
{

Button Slide_Button;
View menu;
View app;
boolean menuOut = false;
AnimParams animParams = new AnimParams();
@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    menu = findViewById(R.id.menu);
    app = findViewById(R.id.app);

    Slide_Button=(Button)findViewById(R.id.BtnSlide);
    Slide_Button.setOnClickListener(OnClick_slide);

    ListView listView = (ListView) app.findViewById(R.id.list);
    ViewUtils.initListView(this, listView, "Itemwa ", 30, android.R.layout.simple_list_item_1);

    ListView listView1 = (ListView) menu.findViewById(R.id.ListView01);
    ViewUtils.initListView(this, listView1, "Itemwana ", 10, android.R.layout.simple_list_item_1);
}

Button.OnClickListener OnClick_slide=new Button.OnClickListener()
{

    @Override
    public void onClick(View arg0)
    {
        // TODO Auto-generated method stub
        System.out.println("onClick " + new Date());
        MainActivity me = MainActivity.this;

        Animation anim;

        int w = app.getMeasuredWidth();
        int h = app.getMeasuredHeight();
        int left = (int) (app.getMeasuredWidth() * 0.8);

        if (!menuOut)
        {

            anim = new TranslateAnimation(0, left, 0, 0);
            menu.setVisibility(View.VISIBLE);
            animParams.init(left, 0, left + w, h);
        } 
        else 
        {

            anim = new TranslateAnimation(0, -left, 0, 0);
            animParams.init(0, 0, w, h);
        }

        anim.setDuration(500);
        anim.setAnimationListener(me);

        anim.setFillAfter(true);

        app.startAnimation(anim);
    }

};

void layoutApp(boolean menuOut) 
{
    app.layout(animParams.left, animParams.top, animParams.right, animParams.bottom);

    app.clearAnimation();

}

@Override
public void onAnimationEnd(Animation animation) 
{
    menuOut = !menuOut;
    if (!menuOut) 
    {
        menu.setVisibility(View.INVISIBLE);
    }
    layoutApp(menuOut);
}

@Override
public void onAnimationRepeat(Animation animation) 
{

}

@Override
public void onAnimationStart(Animation animation)
{

}


static class AnimParams 
{
    int left, right, top, bottom;

    void init(int left, int top, int right, int bottom) 
    {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
}