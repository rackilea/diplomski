class BaseClass extends DerivedClass {    
    public static void main(String[] args) {
        BaseClass b = new BaseClass();
        DerivedClass d = new DerivedClass();
        b.bonus = 200;
        d.bonus = 400;
    }
}