public static void toggleComplete() {
    System.out.print("Enter index of item to toggle complete: ");
    int toggle = k.nextInt();

    toDoItems.get(toggle).setToggle(!toDoItems.get(toggle).isToggled()); 

    // No need for a for-loop since `ArrayList` has the `get` method to do this for you
    //for (int index = 0; index < toDoItems.size(); index++) {
    //    if(toggle == index) {
    //        System.out.println(index + ". [X] " + toDoItems.get(index));
    //    }
    //    else {
    //        System.out.println(index + ". [ ] " + toDoItems.get(index));
    //   }     
    //}   
}