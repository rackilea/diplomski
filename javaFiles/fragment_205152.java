public int pop()
{
    Node temp = top;
    if(!isEmpty())
    {
        top = temp.link;
        size--;
    } else {
           throw new IllegalAccessError();
    }
    return temp.getData();
}

public void push(int value)
{
    Node node = new Node(value);
    if(!isEmpty())
    {
        node.link = top;
        top = node;      
    } else {
        top = node;
    }
    size++;
}
   public String toString()
    {
        String returnStr = "Stack: [";
        Node tmp = top;
        while(tmp != null) {
            returnStr += tmp.getData() + ", ";
            tmp = tmp.link;
        }
        returnStr += "]";

        return returnStr;
    }