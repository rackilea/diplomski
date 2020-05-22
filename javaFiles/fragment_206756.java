while (index > 0) { //String.indexOf can return a 0 as a valid answer. Use -1.
//Looping over something... Why don't you show us the primer code?
    for (int i = 0; i < data.length; i++) {
        /*
        Looping over the `data` array.
        You're filling every value of `data` with whatever is in `index`. Every time.
        This is not what you want.
        */      
        data[i] = index; 
    }

    System.out.println("Index : " + index);
    //OK
    index = input.indexOf(word, index + word.length());
}