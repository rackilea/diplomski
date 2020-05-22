for(CustomStation user1 : localStationLists) 
{
    boolean flag = false;
    for(CustomStation user2 : serverStationLists) 
    {
        if(user1.getStationId().equals(user2.getStationId())) 
        {
            if(!user1.getTitle().equals(user2.getTitle())) 
            {
                resultList.add(user1);
            }            
            resultList.add(user2);
            flag = true;
            break;
        }
    }

    if(flag == false)
    {
        resultList1.add(user1);
    }
}