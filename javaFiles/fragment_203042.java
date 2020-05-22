public class ArrayStack<T extends SteveItemType> {

private SteveItemType[] stack;  
private int top;    
private int default_cap=5;

public ArrayStack(){
      stack = new SteveItemType[default_cap]; 
  }

public ArrayStack(int size) {
    this.stack = new SteveItemType[size];
  }

public String toString(){
      return stack[top].getName();
  }

public void push(T t){
    // push an object
  } 
  // more methods follows
}