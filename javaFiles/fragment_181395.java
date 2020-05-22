public void enq(Object x) {
        Entry help = new Entry(x);

        if (head == null) {

            head = help;

            tail = head;

        } else {
            if (head == tail) {

                head.next = help;
                tail = help;



            } else {

                this.tail.next = help;
                this.tail = help;
            }
        }

    }