static class ClassB {
}

static class ClassA extends ClassB {
}

static void printHierarchy (Class<?> clz) {
    if (clz != null) {
        System.out.println(clz.getSimpleName());
        System.out.print("inherits from: ");
        printHierarchy(clz.getSuperclass());
    } else {
        System.out.println("nothing");
    }
}

public static void main (String[] args) {
    printHierarchy(ClassA.class);
}