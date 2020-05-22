for(int rowIncrement = 0; rowIncrement < arrayofArrays.length; rowIncrement++) {
    for (int columnIncrement = 0; columnIncrement < arrayofArrays[rowIncrement].length; columnIncrement++) {
        if (arrayofArrays[rowIncrement][columnIncrement] == num) {
            System.out.println("The integer you are looking for is in " + rowIncrement + "-" + columnIncrement);
        }
    }
}