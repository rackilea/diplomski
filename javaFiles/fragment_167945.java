class Other {
    public static void act(Observer o) {
        // code here
    }
}

observers.forEach(Other::act);

observers.forEach(obs -> Other.act(obs)); // equivalent lambda