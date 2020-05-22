public static ArrayList<Plan> getNonEmptyPlans(Plan[] plans){
    ArrayList<Plan> list = new ArrayList<Plan>();
    for(Plan p : plans)
        if(!p.allColumnIsNull())
            for(String s : p.getColumns())
                if(s != null)
                    list.add(p);
    return list;                    
}