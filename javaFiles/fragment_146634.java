List<IPDPlayer> currentPlayers = new ArrayList<IPDPlayer>();
Scanner sc1 = new Scanner(System.in);
System.out.println(" How many Tit-for-Tat?");
int in_value = sc1.nextInt();
for(int x = 0; x < in_value; x++)
{
    currentPlayers.add(new TFTPlayer());
}