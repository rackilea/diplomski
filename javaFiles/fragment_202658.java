class Blender<T>{
T t;
public void blendIt(T arg){
//stuff
}
}

class Test {
   public void method() {
     Blender<Apple> blendedApple = new Blender<Apple>();
     blendedApple.blendIt(new Apple()); 
     Blender<Bannana> blendedBannana = new Blender<Bannana>();     
     blendedBannana.blendIt(new Bannana());
   }
 }