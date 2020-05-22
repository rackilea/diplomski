public class AsterisksLast implements Comparator<String>{

@Override
public int compare(String o1, String o2) {


    int numAsterisksInO1 = numberOfAsterisksIn(o1);
    int numAsterisksInO2 = numberOfAsterisksIn(o2);

    if(numAsterisksInO1 == numAsterisksInO2){
        //both contain same number of asterisks
        //(which may be 0)
        //sort 
        //alphabetically
        return o1.compareTo(o2);
    }
    //different number of asterisks sort by fewest
    return Integer.compare(numAsterisksInO1, numAsterisksInO2);

}

private int numberOfAsterisksIn(String s){
    char[] chars =s.toCharArray();
    int count=0;
    for(int i=0; i<chars.length; i++){
        if(chars[i] == '*'){
            count++;
        }
    }
    return count;
}