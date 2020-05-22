interface A{ public int getValue();}
....
public void processValue(A a){}
....
public void showResults(){
    class B implements A{
        int getValue(){
            return value;
        }
    }
    for (int i=0;i<10;i++){
        processValue(new B())
    }
}