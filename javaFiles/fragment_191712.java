private <T> void method1(ClassA classA, List<T> myList){
    if (myList != null){
        //iterate data here...
    }else{
    }
}

// Calling code
method1(myClassA, dataManager.getOne(myClassA.param1));
method1(myClassA, dataManager.getTwo(myClassA.param1));