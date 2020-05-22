LinkedListNode rabbit = head;
LinkedListNode tortoise = head;
while(rabbit != null) { //repeat until the rabit reaches the end of the list
    for(int i = 0; rabbit != null && i < 2; i++) {
        rabbit=rabbit.getNext(); //let the rabbit hop the first and second time
        if(rabbit != null) {
            tortoise=tortoise.getNext(); //let the tortoise hop the first and second time
        }
    }
    if(rabbit != null) {
        rabbit=rabbit.getNext(); //let the rabbit hop a third time
    }
}
return tortoise; //if reached the end, we return where the tortoise ended