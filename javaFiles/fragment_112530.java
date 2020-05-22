List<String> list = new ArrayList<>();
    list.add("Bahamas,32.2233");
    list.add("Zimbabwe,82.2443");
    list.add("India,56.2355");
    list.add("Australia,24.4363");

   List<String> result = list.stream().sorted((a,b)->b.substring(b.lastIndexOf(",")+1).compareTo(a.substring(a.lastIndexOf(",")+1))).collect(Collectors.toList());

 System.out.println(result);  //[Zimbabwe,82.2443, India,56.2355, Bahamas,32.2233, Australia,24.4363]