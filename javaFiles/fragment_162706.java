do {
            count++;
            int first = firstDie.getValue();
            int sec = secondDie.getValue();
            System.out.println(first+ " "+sec);
            if(first==sec ){
                same=true;
                System.out.println("It took "+count+ " times " + first + " and " + sec);
            }
        }
        while(!same);