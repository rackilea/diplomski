class Singleton {
    static Singleton getInstance() {...}
    void addListener(Listener listener) {...}
    void removeListener(Listener listener) {...}
}

class Leaky {
    Leaky() {
        // If the singleton changes the widget we need to know so register a listener
        Singleton singleton = Singleton.getInstance();
        singleton.addListener(new Listener() {
            void handleEvent() {
                doSomething();
            }
        });
    }
    void doSomething() {...}
}

// Elsewhere
while (1) {
    Leaky leaky = new Leaky();
    // ... do stuff
    // leaky falls out of scope
}