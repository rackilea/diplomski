else {
     while (positions.get(0) == index) {
            index = randomGenerator.nextInt(value.length());
     }
     valueChar = value.charAt(index);
     positions.add(index);
     finalValue += Character.toString(valueChar);
}