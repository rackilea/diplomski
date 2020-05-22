if(a<current.x)
    { System.out.println(current.x);
         System.out.println("Trav to left");

      if(current.left!=null)
      {
          current=current.left;
          System.out.println("Entered left of a node");
          System.out.println(current.x);
      } 
      else
       {  
             System.out.println("Node currently null");
          current.left=temp;
          val=false;
        }
    }