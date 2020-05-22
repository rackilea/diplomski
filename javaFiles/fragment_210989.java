class RandomClass(){
     void method1(){
         //do sth for type1
     }
     void method2(){
         //do sth for type2
     }
}

abstract class Type{
     RandomClass randomClass;
     Type(RandomClass randomClass){
         this.randomClass = randomClass;
     }
     abstract void method();
}

class Type1 extends Type{
     void method(){
         randomClass.method1();
     }
}
class Type2 extends Type{
     void method(){
         randomClass.method2();
     }
}