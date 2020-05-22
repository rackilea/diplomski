/**
 * Returns the total rotation of the parent grouping.
 * Does not include this group's rotation.
 **/
public float getTotalParentRotation()
{
    Group g = this.getParent();
    float rotation = 0.00f;
    while (g!=null) {
        rotation += g.getRotation();
        g = g.getParent();
    }
    return rotation;
}