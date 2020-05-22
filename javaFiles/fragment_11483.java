final int chunkSize = 50;

final int[] worldPositions = {241, 186, 30};
final int chunkX = worldPositions[0] / chunkSize;
final int chunkY = worldPositions[1] / chunkSize;
System.out.println("X: " + chunkX + ", Y: " + chunkY); //Output: X: 4, Y: 3