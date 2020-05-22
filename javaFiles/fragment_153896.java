private static int smartestFib(int goalNum, int currentNum, 
     int lastValue, int beforeLastValue) {   
         System.out.println(goalNum);
         if (goalNum == currentNum)
             return lastValue + beforeLastValue;
         else {
            return smartestFib(goalNum, 
                   currentNum + 1, lastValue+beforeLastValue,lastValue);
        }
 }