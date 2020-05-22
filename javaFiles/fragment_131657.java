while (scan.hasNextInt())
{
    int next = scan.nextInt();
    int randomNum = rng.nextInt(256);
    int decipher = next ^ randomNum;
    System.out.print((char)decipher + " ");
}