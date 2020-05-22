class EffetMatrix {
    ...

    public void setCustomTextColor(int color){
        // Set the color to the paintTxt object
        paintTxt.setColor(color);
        // invalidate the view to apply the changes
        invalidate();
    }

    ...
}