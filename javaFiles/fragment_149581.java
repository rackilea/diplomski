interface Movable { public void onMove(); }

class Tank implements Movable {
    public void onMove() { 
        //tank moved! 
    }
}

class MoveService {
    public void move(Movable m) {
        // do what you need to do to move
        // invoke custom code by running a delegate method
        m.onMove();
    }
}