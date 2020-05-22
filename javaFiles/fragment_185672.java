public ArrayList<ArrayList<ArrayList<Integer>>> create3D()
{
    ArrayList<ArrayList<ArrayList<Integer>>> world = new ArrayList<ArrayList<ArrayList<Integer>>>();
    for (int row = 0; row < 3; row++)
    {
        world.add(new ArrayList<ArrayList<Integer>>());
        for (int col = 0; col < 3; col++) 
        {
            world.get(row).add(new ArrayList<Integer>());
            Random rand = new Random();
            int randomNum = rand.nextInt((20 - 1) + 1) + 1;
            for(int humanNumber = 0; humanNumber < randomNum; humanNumber++)
                world.get(row).get(col).add(humanNumber);
        }
        System.out.println();
    }

    return world;
}

public void printHumanGrid(ArrayList<ArrayList<ArrayList<Integer>>> world)
{
    for (int row = 0; row < world.size(); row++)
    {
        for (int col = 0; col < world.get(row).size(); col++) 
        {
            System.out.print("|");
            for(int humanNumber = 0; humanNumber < world.get(row).get(col).size(); humanNumber++)
                System.out.print(world.get(row).get(col).get(humanNumber) + ",");

            System.out.print("|");
        }
        System.out.println();
    }
}