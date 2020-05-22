public static void main(String args[]) throws Exception {

        Child child2 = new Child("ankur", 23);
        Child child1 = new Child("ankurs", 23);
        Child child3 = new Child("ankurss", 21);

        List<Child> childList = new ArrayList<Child>();
        childList.add(child1);
        childList.add(child2);
        childList.add(child3);

        Parent parent = new Parent();
        parent.setApprovable(true);
        parent.setChildList(childList);
        JSONSerializer serializer = new JSONSerializer();
        System.out.println(serializer.exclude("*.class").deepSerialize(parent));

    }