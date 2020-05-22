for (int i = 0; i < allDogsInKennel.size(); i++) {

    //delete any dog object with a status of Accepted
    if (allDogsInKennel.get(i).getStatus().equals("ACCEPTED")) {
        kennel.removeDog(allDogsInKennel.get(i));
        i--   
     }
}