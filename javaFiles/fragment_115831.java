while (index < 7) {
    if (seen.contains(luckyNumber)) {
        luckyNumber = generator.nextInt(49); // here
        continue;
    }
    seen.add(luckyNumber);
    System.out.println("Number " + index + ": " + luckyNumber); 
    index++;
    luckyNumber = generator.nextInt(49);
}
System.out.println("Bonus Number :" + generator.nextInt(49));