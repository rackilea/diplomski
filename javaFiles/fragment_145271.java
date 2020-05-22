for(String s: entry.getValue().split(",")) {
    ///System.out.println(s); move this print statement to below line and see what it prints in your logs
    s = s.replaceAll("[^a-zA-Z0-9]+","");
     System.out.println(s);

    spinnerArray.add(s);
}