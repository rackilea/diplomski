public static Human randomHuman(){
    String[] anArrayOfStrings={"Tom", "Jon", "Chris","Julian","Roberto","Sam","Lisa","Roxanne","Rebecca","Anton","Johannes","Antonella","Bianca"};
    int randomAge = (int) (100*Math.random());
    String randomName = anArrayOfStrings[(int)(Math.random()*anArrayOfStrings.length)];

    Human result = null;

    if ( Math.random() < 0.5 ) {
        // With a probability of 50%, create a plain human
        result = new Human( randomAge, randomName );
    } else {
        // Create a student. Start by calculating a random year.
        int randomYear = (int) (Math.random()*(2013-1932) + 1932);
        result = new Fysiker( randomYear, randomAge, randomName );
    }

    return result;

}