int j;
    try {
        switch(i) {
            case 0:
                for(j = 1; j < 3; j++) {
                    if(gameObject.get(i).peek().getName() < 
                       gameObject.get(i+j).peek().getName()){
                        // do something
                        break;
                    }
                }
            default: 
                // do something
        }
    } catch (EmptyStackException e) {
        int peekThatFailed = j;  //Showing you can use j to determine which peek failed.
    }