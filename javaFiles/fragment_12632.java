interface Worker {
    void work();
}

class Decorated implements Worker {

    public void work() {

    }
}

class DecoratorByInheritance extends Decorated {

    public void work() {
        // pre
        super.work();
        // post
    }
}

class DecoratorByComposition implements Worker {

    Worker decorated;

    DecoratorByComposition(Worker decorated) {
        this.decorated = decorated;
    }

    public void work() {
        // pre
        this.decorated.work();
        // post
    }
}