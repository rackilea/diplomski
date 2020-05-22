double totalCost = Arrays.asList("Shirt", "Jeans").stream().mapToDouble(string -> {
    if (string.equals("Shirt")) {
        return 10.5d;
    } else if (string.equals("Jeans")) {
        return 9.5d;
    } else {
        return 0;
    }
}).sum();
System.out.println(totalCost);