private final Animation fanAnimation;
private Reactor reactor;

public Cooler(Reactor reactor){            //this must be like that
    this.reactor = reactor;  // save the passed in parameter
    fanAnimation = new Animation("resources/images/fan.png", 32, 32, 200);
    setAnimation(fanAnimation);
    fanAnimation.setPingPong(true);
}

@Override
public void act(){
    reactor.decreaseTemperature(1);  // this now refers to the private Reactor instance variable
}