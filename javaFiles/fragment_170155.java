public static void main(String[] args) {
       List<MyClass> list = new ArrayList<>(); 
        list.add(new myClass("John", 12);
        list.add(new myClass("Mike", 16);
        list.add(new myClass("Eric", 13);
        list.add(new myClass("Mark", 142);
        list.add(new myClass("Alex", 112);

        MyClassCollection myclasscollection = new MyClassCollection(list); 
        final List collectionList = myclasscollection.collection(); 
        CollectionUtils.transform(new Converter<myClass, String>() {
            @Override
            public void tranformer(List list) {
                employeeList.clear();
                employeeList.addAll(list);
            }

            @Override
            public String retriever(myClass obj) {
                return obj.name; // make the data member public or add getter 
            }
        }, collectionList);

 collectionList.get(0).toString.toLowerCase(); 

}