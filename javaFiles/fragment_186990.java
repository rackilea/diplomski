LinkedList<MyProcess> q1 = new LinkedList<MyProcess>();

Iterator<MyProcess> iterator = q1.iterator();

while (iterator.hasNext()){

         MyProcess mp = iterator.next();

         if (mp.name.equals("xyz")){

             iterator.remove();    // You can do the modification here.
         }


 }