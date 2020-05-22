public List addList(List newList)   {
    if(newList.info() == null)
                    return this;

    List ref = this;
    List last = ref.last();
    last.setNext(newList.first());
    newList.first().setPrev(last);

    return ref;
}