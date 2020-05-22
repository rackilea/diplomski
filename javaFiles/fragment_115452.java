List<Item> items=new ArrayList<Item>();
   items.add(new Item("A",1.2));
   items.add(new Item("Z",10.2));
   items.add(new Item("B",2.3));
   items.add(new Item("Y",5.4));
   items.add(new Item("B",1.3));


  java.util.Collections.sort(items,new Comparator<Item>()
   {
       public int compare(Item a,Item b)
        {
          if(a.getName().compareTo(b.getName())>0)
            return 1;
          else
          if(a.getName().compareTo(b.getName())<0)
            return -1;
          else
             return 0;            
        }
        public boolean equals(Object a)
         {
            return false;
         }
    });