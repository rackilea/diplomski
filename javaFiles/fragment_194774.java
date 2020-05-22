for(final Object[] candidate : myList){
    if("Some String".equals(candidate[0])){
        System.out.println("Result: " + candidate[1]);
        break;
    }
}