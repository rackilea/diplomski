for (Entry<String, Hashtable<String, Integer>> functionEntry : hash.entrySet()) {
    System.out.println("***************************");                      
    System.out.println(fun);
    System.out.println("***************************");
    for (Entry<String, Integer> subfunction : functionEntry.getValue().entrySet()) {
        System.out.println("#" + subfunction.getKey() + "-" + subfunction.getValue());
    }
}