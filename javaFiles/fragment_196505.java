public final void bar(IntfB obj) {
    if (obj == null)
        System.out.println("I was waiting for an IntfB object but I got nothing!");
    else
        obj.doSomething(100);
}

foo.bar((Integer a) -> {
    System.out.println("I got " + a + " marks for my exam!");
});