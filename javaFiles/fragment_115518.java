done.setOnClickListener(new View.OnClickListener() 
{
@Override
public void onClick(View v) 
  {
    ClassB b = new ClassB();

    ClassB.SimpleThread sx = b.new SimpleThread();

    sx.start();
  }