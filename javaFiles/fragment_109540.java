Random nr = new Random();
int number;
ArrayList<Integer> liste = new ArrayList<Integer>();

// get 50 random numbers between 1 and 100
for(int counter = 1; counter <= 50; ) {
    number = 1+nr.nextInt(100);
    if(!(liste.contains(number))) {
        liste.add(number);
        counter++;
    }
}

for (int ausgabe : liste) {
    System.out.print(ausgabe+ ", ");
}