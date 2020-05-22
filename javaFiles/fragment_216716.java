if (token1.equalsIgnoreCase("start")){
    System.out.println("john");
    String token2 = in.next();
    if(token2.equalsIgnoreCase("picture")){
        System.out.println("doe");
        char inputChar = in.next().charAt(0);  // use a more descriptive name...
        Picture picture = new Picture();
        picture.setName(Character.toString(inputChar)); // note the "generic" name for this picture object variable. The runtime information is stored in the object as a property.
    }
    else{
        System.out.println("Improper imput from file");
    }
}