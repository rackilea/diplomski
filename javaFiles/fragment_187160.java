if (!integer.equals("")){
    throw new NotIntException("Wrong data type-check fields where an integer"+
    " should be.");
}

if (integer.equals("-")){
    System.out.println(integer);
    throw new NotIntException("Error-Can't have a negative count.");
}