static int cardNumber = rnd.nextInt(13) + 1;
if (cardNumber == 1 || cardNumber >= 11)
{
    System.out.println(faceCard + " of " + suit);
} 
else 
{
    System.out.println(cardNumber + " of " + suit);
}