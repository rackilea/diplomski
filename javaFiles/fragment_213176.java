while(scan.hasNext()){
    letter = scan.next();

    if(wordMap.containsKey(letter)) wordMap.put(letter, value++);  // problem

    else wordMap.put(letter, new Integer(value++));
}