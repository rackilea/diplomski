String word = "bottles";
for(int beerNum = 99; beerNum > 0; beerNum --) {
     if(beerNum==1) {
         word = "bottle";
    }
    System.out.println(beerNum + " " + word + " of beer on the wall");
    System.out.println(beerNum + " " + word + " of beer");
    System.out.println("Take one down.");
    System.out.println("Pass it around.");
    if (beerNum > 1) {
       System.out.println(beerNum -1 + " " + word + " of beer on the wall");
    } else {
       System.out.println("No more bottles of beer on the wall");
    }
}