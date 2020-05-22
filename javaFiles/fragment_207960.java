interface Activity {
    Activity run(SharedContext context);
}

class A implements Activity {
    public Activity run(SharedContext context) {
        doA(context);
        return new B();
    }
}

class B implements Activity {
    public Activity run(SharedContext context) {
        doB(context);
        return new C();
    }
}

// runtime controller
SharedContext context = new SharedContext();
Activity next = new A();

while (next != null) {
    next = next.run(context);
}