do {
    oystersIn=0;
    System.out.println("How many oysters are coming in?");
    oystersIn = input.nextInt(); 
    if (oystersIn + currentCapacity >= 500) {
        System.out.println("Sorry full - waiting for some one to leave");
        continue;
    }
    if (oystersIn + currentCapacity < 0) {
        System.out.println("Can't go negative");
        continue;
    }
    currentCapacity += oystersIn;
    System.out.println("Now there are " + currentCapacity + " oysters in the bar");
}
while (true);