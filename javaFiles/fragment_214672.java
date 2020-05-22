//ensures that pattern is unique AND four digits long
public void repeatCheck(){
    solutionNumber();
    int patternNum = Integer.parseInt(pattern);
    while((secondSolnDigit==firstSolnDigit)||(firstSolnDigit==thirdSolnDigit)||
    (firstSolnDigit==fourthSolnDigit)||(secondSolnDigit==thirdSolnDigit)||
    (secondSolnDigit==fourthSolnDigit)||(thirdSolnDigit==fourthSolnDigit) || patternNum<1000){
        numGen();
    }

    return pattern;
}
//generates random number
public void numGen();{
    Random rand = new Random();
    int randomNum = rand.nextInt(10000);
    String patternString = Integer.toString(randomNum);
    pattern = patternString;
}