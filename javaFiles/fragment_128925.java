ArrayList<String> listed = new ArrayList<>();
    listed.add("sun, water, autumn");
    listed.add("moon, wind, winter");
    listed.add("venus, fire, summer");
    List<String> subList1=new ArrayList<>();
    List<String> subList2=new ArrayList<>();
    List<String> subList3=new ArrayList<>();
    for(String i:listed){
         subList1.add(i.split(",")[0]);
         subList2.add(i.split(",")[1]);
         subList3.add(i.split(",")[2]);
    }