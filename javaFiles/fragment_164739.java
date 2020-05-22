public void add(int element){

            Node n = new Node();
            n.setItem(element);
            n.setNext(head); 
            n.setBefore(null); 
            if(head != null) 
                head.setBefore(n); 
            else{
                tail=n; // if head == null then now you have an element so head = tail
            }

            head = n;        
    }