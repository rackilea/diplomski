class Packet {

protected int myInt1; // accessible in subclass
protected int myInt2;
private int myInt3; // not accessible by child class

}

class SubPacket extends Packet {
}