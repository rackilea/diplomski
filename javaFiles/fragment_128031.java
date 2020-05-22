static HashMap<Class, Integer> refCount = new HashMap<Class, Integer>();

Node(E data, Node<E> next) 
{
    this.data = data;
    this.next = next;
    GlobalCount++;

    Class type = data.getClass();

    Integer countObj = refCount.get(type);
    int count = 1;
    if(countObj != null)
    {
        count = countObj.intValue();
        count++;
    }
    refCount.put(type, count); 
}