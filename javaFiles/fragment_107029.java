@Override
public Action action() {
    Random rand = new Random();
    action.shoot = rand.nextBoolean();
    action.thrust = rand.nextInt(2);
    action.turn = rand.nextInt(3) - 1;
    return action;
}