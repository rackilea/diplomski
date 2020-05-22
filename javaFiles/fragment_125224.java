int sum=0;
for (int i=0; i<grades.size();i++){
    sum+=grades.get(i);               //adding all the grades in variable sum
}
double avg= sum/grades.size();      //dividing the sum with total number of 
                                    //grades to calculate average
System.out.println("average grade :" + avg);