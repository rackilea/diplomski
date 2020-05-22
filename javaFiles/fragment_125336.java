// delete an item from the linked list

    public void delete(int pos)

     {

       if (countitem() > 0){ 

       //make sure the list is not empty.

      ListNode<T> temp,del;

      if (pos== 1){

          //delete the first item
            if(countitem()==1){ //The list contains only one item
                pfirst=null;
                plast=null;

              }else
         { 
           //The list contains more than one item
           temp=pfirst;

           pfirst=pfirst.next;

           temp=null;
        }
        System.out.println("Deleted");


     }

        else if (pos > 1 && pos <=countitem()){

          //delete middle item

          temp=pfirst;

          int i;

      for(i=1;i<pos-1;i=i+1)

          {temp=temp.next;} //move to the item staying before the target item to be deleted

         del=temp.next; //target item to be deleted

         temp.next=del.next;

         if(del.next==null)

         plast=temp; //delete last item

         del=null;


         System.out.println("Deleted");

        }

    else System.out.println("Invalid position!");

    }

  else System.out.println("No item found");

 }