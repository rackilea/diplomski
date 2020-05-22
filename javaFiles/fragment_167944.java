class Observer {
    public void act() {
        // code here
    }
}

observers.forEach(Observer::act);

observers.forEach(obs -> obs.act()); // equivalent lambda