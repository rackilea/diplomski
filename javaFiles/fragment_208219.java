public class Parent(){
   public static int childOneUses, childTwoUses;
   public static int childType;

   public Parent(int childType) {
      this.childType = childType;
   }

   public void example(){
    if(childType == 1) {
        childOneUses++;
    }
    else if(childType == 2) {
        childTwoUses++;
    }
   }
}

public class ChildOne extends Parent(){
  public ChildOne() {
    super(1);
  }
}

public class ChildTwo extends Parent(){
  public ChildTwo() {
    super(2);
  }
}

public static void main(String[] args){
ChildOne childOne = new ChildOne();
ChildTwo childTwo = new ChildTwo();

childOne.example();

childTwo.example();
childTwo.example();
}