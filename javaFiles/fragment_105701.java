public Container modifiedReference(){
    Container c = new Container();
    c.set("Important msg");
    try{
        return c;
    }finally{
        c.set("Meaning of life");
    }
}