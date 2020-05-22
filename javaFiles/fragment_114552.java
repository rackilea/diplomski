public static void main(String[] args) {
        final List<No2> no2List = new ArrayList<No2>();
        no2List.add(new No2("1","A",3,6000));
        no2List.add(new No2("2","B",4,8000));
        no2List.add(new No2("3","C",1,1000));
        no2List.add(new No2("4","D",2,4000));
        no2List.add(new No2("5","E",5,10000));
        no2List.add(new No2("6","F",2,4000));
        no2List.add(new No2("7","G",3,6000));

        for (final No2 no2 : no2List) {
            System.out.println(no2.toString());
        }
    }