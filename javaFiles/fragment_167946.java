class Other {
    void act(Observer o);
}

Other other = new Other();
observers.forEach(other::act);

observers.forEach(obs -> other.act(obs)); // equivalent lambda