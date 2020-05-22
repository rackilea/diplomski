@GET
    @Path("/test2")
    public JaxbList test2(){
        List list=new Vector();
        list.add("a");
        list.add("b");
        return new JaxbList(list);
    }