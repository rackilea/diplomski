//DataType is substituted for whatever you tell it in <...> when making a Stack object
public class Stack<DataType> { 

    private List<DataType> memory = new ArrayList<>();

    public void push(DataType e) {
        memory.add(e);
    }

    public DataType pop() {
        if(memory.isEmpty())
           return null;
        int lastIndex = memory.size()-1;
        DataType element = memory.get(lastIndex); //get last element of memory
        memory.remove(lastIndex); //remove it from the stack
        return element; //return it   
    }

    public boolean isEmpty() {
        return memory.isEmpty();
    }
}