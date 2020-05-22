public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList l1= new ArrayList();
        l1.add("Belgaum");
        l1.add("Bangalore");

        ArrayList l2 = new ArrayList<>();
        l2.add(""+"India");
        System.out.print("       ");
        System.out.println(l2.get(0));

        ArrayList l3= new ArrayList();
        l3.add("Pune");
        l3.add("Mumbai");

        HashMap hashmap = new HashMap();
        hashmap.put("Karnataka", l1);
        hashmap.put("Maharashtra",l3);

        Set s1=hashmap.entrySet();

        Iterator i1=s1.iterator();
        while(i1.hasNext()){
            Map.Entry m1=(Map.Entry)i1.next();
            String tmpStr = m1.getKey().toString();
            ArrayList<String> tmpList = (ArrayList<String>) m1.getValue();
            for (String s : tmpList){
                tmpStr = tmpStr + " " + s;
            }
            System.out.println(tmpStr);
        }
    }