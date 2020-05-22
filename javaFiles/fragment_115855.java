private static boolean removeSpecfiedNumber(int number,int numberOfTimes, List<Integer> integerList){
        if(integerList.stream().filter(x -> x == number).count() >= numberOfTimes){
             for (int i = 0; i < numberOfTimes; i++) {
                 integerList.remove((Integer)number);
             }
             return true;
        }
        return false;
}