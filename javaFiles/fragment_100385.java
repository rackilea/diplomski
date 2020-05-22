String [] myArray ;
    if (stringArrayList.size()>0){
        Iterator<String [] > i = stringArrayList.iterator();
        while(i.hasNext()){
                  myArray =  i.next();
                  for(String s : myArray)
                      System.out.println(s);
                }
                }

        }