int rn1 = boarduser[new Random().nextInt(boarduser.length)];
System.out.println("Computer's Value: " + rn1);
int rn2 = boarduser[new Random().nextInt(boarduser.length)];
while(rn2 == rn1)
{
    rn2 = boarduser[new Random().nextInt(boarduser.length)];
}
System.out.println("Computer's Value: " + rn2);