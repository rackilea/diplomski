String[] item ={"[1]hotdog", "[2]eggpie","[3]menudo","[4]pizza","[5]lumpia"};
int[] cost = {5, 10, 15, 20, 25};
int[] selling = {10,15,20,25,30,};
int[] qty = {2,4,6,8,10};
for (int i = 0; i < item.length; i++)
{
    System.out.println(" " +item[i]+"\t"+cost[i]+"\t\t"+selling[i]+"\t\t"+qty[i]);
}