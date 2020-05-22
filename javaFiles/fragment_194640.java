Interface Myinterface{
   public void interfacemethod(); 
}

class A implements Myinterface
{  
    C instance = new C ((Myinterface)this);

    public void interfacemethod()
}

class B implements Myinterface
{    
    C instance = new C ((Myinterface)this);
    public void interfacemethod()
}

Class C extends someListerner
{
    Myinterface ml;
    public C(Myinterface arg_ml){
        ml = arg_ml;
    }
    public void listenercalled()
    {
        ml.interfacemethod();
        //here i want to call the callers interfacemethod()
    }
}