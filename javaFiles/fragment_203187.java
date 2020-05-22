public HashMap<String, List<String>> getSortedHashMapForEmployees(string searchKeyword,List<yourDtoFromDB> orginalListFromDB)
    {
        HashMap<String, List<String>>hashmap=new HashMap<String, List<String>>();
        for (List<yourDtoFromDB> orginalList : orginalListFromDB) 
        {
            if(orginalList.getName().contains(searchKeyword))
            {
                List<String>accountNo=new ArrayList<String>();
                if(hashmap.containsKey(orginalList.getName()))
                {
                    accountNo=hashmap.get(orginalList.getName());
                }
                accountNo.add(orginalList.getAccountNo());
                hashmap.put(orginalList.getName(), accountNo);
            }
        }
        return hashmap;

    }