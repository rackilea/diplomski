MyDraw d;
@Override
public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    d = new MyDraw (this);
    setContentView (d);
}