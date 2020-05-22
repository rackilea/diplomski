public static double avg(List<int> vec){

    //Sum all numbers
    long sum = 0;


    for(int i=0;i<vec.size();i++){
        sum = sum + vec.get(i);
    }

    //Divide by the number of numbers
    double avg = sum/vec.size();

    //Return the average
    return avg;    
}