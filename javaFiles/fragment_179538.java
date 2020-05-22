while (run) {
            if (currentLink.data == num) {
                currentLink.size--;
                if (currentLink == head) {
                    if (head == head.next) { //make sure to handle a case where we are removing head from the list that has only one node
                        head = null;
                        break;
                    } else { //we removed a head, move current head to the new one and set currentLink to the next node from head
                        head = head.next;
                        currentLink = head.next;
                        previousLink = head;
                    }
                } else {
                    previousLink.next = currentLink.next;
                    currentLink = currentLink.next;
                }
            } else { //no match move on to the next node
                previousLink = currentLink;
                currentLink = currentLink.next;
                if (currentLink == head) run = false;
            }
        }