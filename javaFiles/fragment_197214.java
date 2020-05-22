List<ThirdClass> a3 = new ArrayList<ThirdClass>();

    for(FirstClass  first: a1) {

        ThirdClass third = new ThirdClass();

        for( SecondClass second: a2) {

            if(first.getName().equalsIgnoreCase(second.getName())) {

                third.setName(second.getName());

                if(second.getStatus() ==1){

                    third.setStatus1(second.getStatus());
                }
                else if(second.getStatus() ==2){

                    third.setStatus2(second.getStatus());
                }
                else if(second.getStatus() ==3){

                    third.setStatus3(second.getStatus());
                }
            }
        }
        a3.add(third);
    }