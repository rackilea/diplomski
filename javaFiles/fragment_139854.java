class HashCollider
{
    static class Hashable
    {
        private static int curr_id = 0;
        public  final  int id;

        Hashable()
        {
            id = curr_id++;
        }
    }

    public static void main(String[] args)
    {
        final int NUM_OBJS = 200000; // birthday problem suggests
                                     // this will be plenty

        Hashable objs[] = new Hashable[NUM_OBJS];  
        for (int i = 0; i < NUM_OBJS; ++i) objs[i] = new Hashable();

        for (int i = 0; i < NUM_OBJS; ++i)
        {
            for (int j = i + 1; j < NUM_OBJS; ++j)
            {
                if (objs[i].hashCode() == objs[j].hashCode())
                {
                    System.out.println("Objects with IDs " + objs[i].id
                                     + " and " + objs[j].id + " collided.");
                    System.exit(0);
                }
            }
        }

        System.out.println("No collision");
    }
}