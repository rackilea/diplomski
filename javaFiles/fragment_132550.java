for(java.lang.management.MemoryPoolMXBean memoryPoolMXBean :java.lang.management.ManagementFactory.getMemoryPoolMXBeans())
{
    System.out.println("");
    try
    {
        System.out.println("PoolName\t" + memoryPoolMXBean.getName());
        System.out.println("Commited\t" + memoryPoolMXBean.getCollectionUsage().getCommitted());
        System.out.println("Init\t" + memoryPoolMXBean.getCollectionUsage().getInit());
        System.out.println("Max\t" + memoryPoolMXBean.getCollectionUsage().getMax());
        System.out.println("Used\t" + memoryPoolMXBean.getCollectionUsage().getUsed());
    }
    catch (NullPointerException npex)
    {
        npex.printStackTrace();
    }
}