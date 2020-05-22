***   Object [] result = (Object []) response;   ***
List<Object> user = Arrays.asList(result);

    for (int i = 0; i< user.size(); i++){

       if (user.get(i) != null){
           list.add(((Learner) user.get(i)).getFirstName().toString() + ": " + ((Learner) user.get(i)).getLastName().toString());
       }
    }