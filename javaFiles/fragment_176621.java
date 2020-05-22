while (!good){
    if (!in.hasNextInt()){
        in.next();
        System.out.print("Sorry, you must enter a whole\nnumber between 1 and 6: ");
    } else {
        level = in.nextInt();
        if (level < 0 || level > 6) {
            System.out.print("Sorry, you must enter a whole\nnumber between 1 and 6: ");
        } else {
            good = true;
        }
    }
}