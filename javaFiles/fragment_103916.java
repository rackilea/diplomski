for(int i =0; i < numbers.size(); i++){
    testNum = numbers.get(i);
        if(testNum > lowerLimit && testNum < upperLimit){
        count++;
        }
}
System.out.println(count + " valid numbers have been entered!");