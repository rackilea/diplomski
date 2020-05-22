public abstract class Test{

  public int singleReturn(){   
     int ret = 0;
     if (cond1())
         ret = 1;
     else if (cond2())
         ret = 2;
     else if (cond3())
         ret = 3;

    return ret;
  }

  public int multReturn(){
    if (cond1()) return 1;
    else if (cond2()) return 2;
    else if (cond3()) return 3;
    else return 0;
  }

  protected abstract boolean cond1();
  protected abstract boolean cond2();
  protected abstract boolean cond3();
}