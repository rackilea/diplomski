while (iterator.hasNext()){
        s = iterator.next();
        if (s.empty()){
            iterator.remove();
            continue;
        } 
        System.out.println(s.pop());            
    }