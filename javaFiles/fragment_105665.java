class A { ... }
class B { ... }
void method(){
    Class[] array = {A.class, B.class, A.class, A.class};
    int i = 2;
    Object object = array[i].newInstance();
}