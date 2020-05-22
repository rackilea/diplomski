double average = citylist.stream()
        .mapToDouble(Apartment::getRabat)
        .average()
        .orElse(-1);

System.out.println("Average price : " + average);