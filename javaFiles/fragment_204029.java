StringBuilder strbld=new StringBuilder();
    int length=maxLength-minLength+1+minLength;
    System.out.println("n     "+strbld.append(UpperCase[rand.nextInt(point1)]));//;

    //get a uppercase char
    strbld.append(Digit[rand.nextInt(point2)]);
    for(int i=0;i<length-2;i++){
        strbld.append(Mixed[rand.nextInt(point3)]);