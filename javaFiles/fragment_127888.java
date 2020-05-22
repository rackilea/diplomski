public void sort() {
        if (size > 1) {
            boolean wasChanged;

            do {
                Node current = head;
                Node previous = null;
                Node next = head.nextNode;
                wasChanged = false;

                while ( next != null ) {
                    if (current.data > next.data) {
                        /*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
                        wasChanged = true;

                        if ( previous != null ) {
                            Node sig = next.nextNode;

                            previous.nextNode = next;
                            next.nextNode = current;
                            current.nextNode = sig;
                        } else {
                            Node sig = next.nextNode;

                            head = next;
                            next.nextNode = current;
                            current.nextNode = sig;
                        }

                        previous = next;
                        next = current.nextNode;
                    } else { 
                        previous = current;
                        current = next;
                        next = next.nextNode;
                    }
                } 
            } while( wasChanged );
        }
    }