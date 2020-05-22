if (n.getProb() <= curr.getProb()) {
                n.setNext(curr);
                n.setPrev(curr.getPrev());
                if (curr.getPrev() != null)
                     curr.getPrev().setNext(n);//set next to curr's prev
                curr.setPrev(n);
            } else if (n.getProb() > curr.getProb()) {
                n.setNext(curr.getNext());
                n.setPrev(curr);
                if (curr.getNext() != null)
                     curr.getNext().setPrev(n);//set prev to curr's next
                curr.setNext(n);
            }