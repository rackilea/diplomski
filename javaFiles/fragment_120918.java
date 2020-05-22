System.out.println("You take " + playertake + " stones. There are " + rockCount + " left");

int computerTake = 0;

computerTake = nimMethods.computerTake();

rockCount = rockCount - computerTake;

System.out.println("The computer takes " + computerTake + " stones. There are " + rockCount + " left");