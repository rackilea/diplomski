long native_types[];
try {
    /*
     * Retrieve the drop target context.
     *
     * We can retrieve this member directly, because it's a public field.
     */
    DropTargetContext dtc = ( ( DropTarget ) dtde.getSource() ).getDropTargetContext();
    /*
     * Retrieve the drop target context peer.
     *
     * We cannot retrieve this member without reflection, because it's a private field. We get the class
     * object from the public class declaration. The field "dropTargetContextPeer" is private, so we
     * have to retrieve with a reflection call and then set it to be accessible so that we don't get
     * IllegalAccessException when we call get() on the field. Since we're only going to use reflection
     * on the drop target context peer, we don't bother trying to cast it and just leave it declared
     * as Object.
     */
    Class<DropTargetContext> DTC_class = DropTargetContext.class;
    Field DTCP_field = DTC_class.getDeclaredField( "dropTargetContextPeer" );
    DTCP_field.setAccessible( true );
    Object dtcp = DTCP_field.get( dtc );
    /*
     * Retrieve the array of native types.
     *
     * This is almost exactly analogous to the previous retrieval, but with the exception that the field
     * is defined in the superclass, not the class itself. Because the field is declared private, we can't
     * simply use getField(), since that only works on public fields. So we get the class object for the
     * parent class and proceed as before.
     *
     * As a bonus, this routine is cross-platform. The class sun.awt.windows.WDropTargetContextPeer is
     * the implementation class for sun.awt.dnd.SunDropTargetContextPeer for Windows. The type identifiers,
     * though, all fit into a long for every platform.
     */
    Class<?> DTCP_class = dtcp.getClass();
    Class<?> DTCP_superclass = DTCP_class.getSuperclass();
    Field CT_field = DTCP_superclass.getDeclaredField( "currentT" );
    CT_field.setAccessible( true );
    native_types = ( long[] ) CT_field.get( dtcp );
} catch ( Exception e ) {
    throw new RuntimeException( "Did not retrieve native types.", e );
}