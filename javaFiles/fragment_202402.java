double maxheight = -1.0d;
double minheight = 1000.0d;
String maxname = "";
String minname = "";

while (true)
{
    String name = System.console().readLine();
    double height = Double.parseDouble(System.console().readLine());

    if(height < 0.8 || height > 2.5)
    {
        System.out.println("%d is to large or to small", height);
        continue;
    }

    if (height > maxheight)
    {
        maxname = name;
        maxheight = height;
    }

    if (height < minheight)
    {
        minname = name;
        minheight = height;
    }

    System.out.println("%s is heighest person with %d meters", maxname, maxheight);
    System.out.println("%s is lowest person with %d meters", minname, minheight);
}