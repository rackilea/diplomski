/**
 * Returns the z-order index of the component inside the container. 
 * The higher a component is in the z-order hierarchy, the lower
 * its index.  The component with the lowest z-order index is
 * painted last, above all other child components.
 *
 * @param comp the component being queried
 * @return  the z-order index of the component; otherwise 
 *          returns -1 if the component is <code>null</code>
 *          or doesn't belong to the container 
 * @see #setComponentZOrder(java.awt.Component, int)
 * @since 1.5
 */
public int getComponentZOrder(Component comp) {
        }