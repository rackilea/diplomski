public static Human randomHuman(){
        String[] anArrayOfStrings={"Tom", "Jon", "Chris","Julian","Roberto","Sam","Lisa","Roxanne","Rebecca","Anton","Johannes","Antonella","Bianca"};
        int randomAge = (int) (100*Math.random());
        String randomName = anArrayOfStrings[(int)(Math.random()*anArrayOfStrings.length)];
        int RandomYear = (int) (Math.random()*(2013-1932) + 1932);
//        if(xx instanceof Fysiker){
//            
//        }
        return new Human(randomAge,randomName);
    }