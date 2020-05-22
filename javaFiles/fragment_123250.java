int tmpInt = 0;
boolean flag = false;
while ((flag = !console.hasNextInt()) || (tmpInt = console.nextInt()) < 0){
    if (flag) {
        console.next();
        flag = false;
    }
    System.out.println("Value must be a positive integer !");
}