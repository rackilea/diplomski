interface DoWithFM {
   void <T> run(FactManager<T> t);
}

...
for (FactManager<?> factManager : factManagers) {
    ...
    new DoWithFM() { public <T> run(FactManager<T> factManager) {
        for (T fact : factManager) {
            factManager.doSomething(fact);
        }
    }.run(factManager);
    ...
}
...