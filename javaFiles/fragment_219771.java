public static void RandomSchedules(ArrayList<String[]> list)
{
    Random randomizer = new Random(System.currentTimeMillis());
    for(int i=1; i<11; i++)
    {
        String[] random = list.get(randomizer.nextInt(list.size()));
        System.out.println("Random Schedule " +  ":" + Arrays.toString(random));
    }
}