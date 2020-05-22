public void add(Object o, int index){
    Object[] temp;
    if(index >= 0 && index < elements.length)
        temp[index] = o;
        size++;
    else{
        temp=creatList(elements.length * 2);
        for(int i=0;i < elements.length;i++){
            if(i<index)
                temp[i]=elements[i];
            else if(i==index)
                temp[i]=o;
            else
                temp[i]=elements[i+1];
        }
        temp[index] = 0;
        size++;
        this.elements = temp;
    }
}