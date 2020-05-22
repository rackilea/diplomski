if(a<current.x)
    { System.out.println(current.x);
         System.out.println("Trav to left");
      current=current.left;
      if(current==null)
       {  
             System.out.println("Node currently null");
          current=new tree();
          current=temp;
          System.out.println("Entered left of a node");
          System.out.println(current.x);
          val=false;
        }
    }