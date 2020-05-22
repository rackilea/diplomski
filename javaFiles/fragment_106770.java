Scanner sc = new Scanner(System.in);

long sTime = System.currentTimeMillis();
while (System.currentTimeMillis() - sTime < 5000)
{
    if (System.in.available() > 0)
    {
        System.out.println(sc.nextLine());
    }
}

sc.close();