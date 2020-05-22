long filterNameCount = custNames
        .stream()
        .parallel() 
        .filter((s) -> s.startsWith(nameStarts.toLowerCase()))
        .count();

System.out.println(filterNameCount);