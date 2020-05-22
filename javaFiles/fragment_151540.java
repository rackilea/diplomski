public class MyStack implement IStack{
      public Object pop() throws StackEmptyException{
        if(size==0){throw new StackEmptyException();}
        //otherwise return the last component. return stack[size--];
      };
      public void push(Object o)throws StackOverFlow{if(size==stack.length-1){throw new StackOverFlow();}};
      public boolean isEmpty(){return size==0;};
      public int size(){return size;};
      public void clear(){size=0;};
      ///////////////
      private Object[] stack;
      private final static default_stack_size=16;
      private boolean can_extended=false;
      public MyStack(){stack=new Object[16];}
      public MyStack(int size){stack=new Object[size];}
}