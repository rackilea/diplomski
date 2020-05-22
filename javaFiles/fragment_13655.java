mainPersonnelList.sort((Personnel o1, Personnel o2) -> {
        String o1Str = o1.getPersonnelName();
        String o2Str = o2.getPersonnelName();
        if(o1Str.isEmpty()){
            return o2Str.isEmpty() ? 0 : -1;
        }
        if(o2Str.isEmpty()){return 1;}
        return o1Str.compareTo(o2Str);
    });