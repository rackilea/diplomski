static Map getMap(List animalsToReturn) {
    Map result = [:]

    // do some stuff...
    for (animal in animalsToReturn){
        MyEnum myEnum = MyEnum[animal]
        result.put(myEnum.animalType, myEnum.sound)
    }
    result
}