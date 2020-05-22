Random rand = new Random();
int a,b;
while(true)
{
    a = rand.nextInt(401) + 100;
    b = rand.nextInt(401) + 100;
    if(a>b) {
        System.out.println("B value: " + b);
        break;
    }
}