public static void main(String[] args)
{
    Plan[] p = createDummyData();

    //Display All Data
    displayAllData(p);

    //Display non-null data
    ArrayList<Plan> list = getNonEmptyPlans(p);
    Plan[] p2 = list.toArray(new Plan[list.size()]);        
    displayAllData(p2);                                             
}