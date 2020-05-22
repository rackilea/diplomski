ArrayList<UIToto> totoList = retrieveTotoList;
ArrayList<UIToto> resultList= new ArrayList<UIToto>();

String[] ids = {"dqs4d65q4-45d4s54545sfd-dfss54545", 
                "4545-dsqd45-dqs,4d5s44-ss4-dqsd"}; 

for(int i = 0; i < ids.length; i++) {
    for(UIToto uIToto : totoList) {
        if(uIToto.getId().equals(ids[i])) {
            resultList.add(uIToto);     
        }
    }
}