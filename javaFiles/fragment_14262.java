while(input.hasNext()) {
    if (input.hasNextInt()) {
       year = input.nextInt();
       break;
    } else {
        System.out.println("year of birth can only have numbers");
        input.next();
    }
}
input.close();