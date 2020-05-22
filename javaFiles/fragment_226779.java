String rName = sc.nextLine();
try {
    if(rName.isEmpty()){
        throw new NullPointerException("Name cannot be blank.");
    }
}