class Outer {

    ClassA a;
    ClassB b;
    ClassC c;
    Map<MyEnum,Double> results= new EnumMap<MyEnum, Double>(MyEnum.class);
    private enum MyEnum{
        X{  public void calc(Outer o){ }           },
        Y{  public void calc(Outer o){  } },
        Z{  public void calc(Outer o){ } };
        abstract void calc(Outer o);
    }

    public void doCalc(){
        for(MyEnum item:MyEnum.values()){
            item.calc(this);
        }
    }
}


class ClassA {}
class ClassB {}
class ClassC {}