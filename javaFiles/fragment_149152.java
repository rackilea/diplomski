public static float[] getInheritedScale(@NonNull View v)
{
    if(v.getParent() == null || !(v.getParent() instanceof View)){
        return new float[]{v.getScaleX(), v.getScaleY()};
    }

    float[] coords = new float[2];

    coords[0] = v.getScaleX();
    coords[1] = v.getScaleY();

    // Iterate through the View's family tree, getting each parent View's scale and calculating
    // it into the total scale factor.
    boolean done = false;
    View current = (View)v.getParent();
    while(!done)
    {
        coords[0] = coords[0] * current.getScaleX();
        coords[1] = coords[1] * current.getScaleY();

        // Check that we have not reached the top of the tree. If we have, set the done flag.
        if(current.getParent() != null && current.getParent() instanceof View){
            current = (View)current.getParent();
        }else{
            done = true;
        }
    }

    return coords;
}