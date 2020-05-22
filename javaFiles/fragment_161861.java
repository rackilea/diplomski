hm.forEach((key, value) -> {
            boolean allTrue=true;
                        for (Object object : value) {
                            allTrue = (boolean)object;
                            if(!allTrue){ //stop if you found a false in the true/false array
                                break;
                            }
                        }//out of the inner iteration
                        if(allTrue){//if this variable is true, it means the above iteration had all values true
                            //do your stuff
                            break;
                        }
                        allTrue=true; //reset
            });