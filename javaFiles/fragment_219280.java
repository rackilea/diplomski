public T peek(){
    if (isEmpty()) {
        throw new RuntimeException("Stack is empty");
    }   
    return top.data;        
}