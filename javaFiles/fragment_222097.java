List<Object> list = new ArrayList<Object>();
         list.add(new Cat());
         list.add(new Dog());
         list.add(new Animal());
         list.add(new Cat());

         for (int i = 0; i < list.size(); i++) {

             if(list.get(i) instanceof Cat){
                 System.out.println("Cat at "+i);
             }else if(list.get(i) instanceof Dog){
                 System.out.println("Dog at "+i);
             }else if(list.get(i) instanceof Animal){
                 System.out.println("Animal at "+i);
             }
        }