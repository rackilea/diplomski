public Animal search(String name) {     //Method definition, parameter named name

    Animal result = null;               //Variable declaration to hold the result
    for (Animal a : animals) {          //for each loop, looping on all the animals and the current animal is stored in variable named a
        if (name.equals(a.getName())) { //check if current animal's name is equal to parameter's value
            result = a;                 //Yes, store it in result variable
        }
    }
    return result;                      //In the end return result, it could be null if no animal is found
}