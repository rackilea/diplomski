public  ListNode mergeKLists(ListNode[] lists) {

    int amount = 0;
    int length = lists.length;
    while(amount!= 1){
        amount = 0;
        if(lists.length%2 == 0){
            for (int i=0; i<length; i++){
                lists[amount] = merge2lists(lists[i] , lists[i+1]);
                amount++;
                i++;
            }
           length = amount;
        }
        else{.....}
  }