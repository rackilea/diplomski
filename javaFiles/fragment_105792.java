public void delete(){
    if(head == null){
        System.out.println(List is empty...);
    }
    else{
       NodeAlex tmp = head;
       head = tmp.getNextRef();
       if(head == null){ // you need to check if head == tail or head.getNextRef() == null
          tail = null; // here you have to set tmp.setNextRef(null);
                       // and additionally define tmp as tail.
      }
      System.out.println(Deleted +tmp.getValue());
      System.out.println(First Employee Name Deleted!);
    }
}