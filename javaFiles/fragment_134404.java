class A
{
Context con;
public A(Context con)
    {
    this.con=con
    }
}



Activity B
{
Context con;
  @Override
  public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         this.con=getContext();
         A = new A(this.con);
    }
}