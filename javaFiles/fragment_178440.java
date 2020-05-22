class PPACKET_OID_DATA extends Struct {

    public final UnsignedLong Oid = new UnsignedLong();
    public final UnsignedLong Length = new UnsignedLong();
    public final Unsigned8[] Data = array(new Unsigned8[6]);

    public PPACKET_OID_DATA(Runtime runtime) {
        super(runtime);
    }

}