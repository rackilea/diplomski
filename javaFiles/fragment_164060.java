public void add(int num) {
    // Code above this remains same

            if(current.next.num >= num) { //if next number is greater than number we want to add then we've found the spot to add it to

                Node actualNext = current.next;    // Missed

                current.next = new Node(num, current.next, current);

                actualNext.previous = current.next;   //Missed

 // Code below this remains same
}