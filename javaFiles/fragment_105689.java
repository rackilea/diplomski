static abstract class Super {
    public String saySomething() {
        return "I'm Super";
    }
}

static class Child1 extends Super {
    @Override
    public String saySomething() {
        return "I'm Child1";
    }
}

static class Child2 extends Super {
    @Override
    public String saySomething() {
        return "I like coffee!";
    }
}

private static List<? extends Super> myList;

public static void main(String[] args) {
    myList = new ArrayList<>();
    addSomeData(myList, new Child1());
    addSomeData(myList, new Child2());

    myList.forEach(element -> System.out.println(element.saySomething()));
}

public static void addSomeData(List someList, Object data) {
    someList.add(data);
}