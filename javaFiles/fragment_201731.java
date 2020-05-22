if(a[0][0][0]<1)
{
    // disable all buttons
    for(ImageButton button : buttons) {
        button.setEnabled(false);
        button.setAlpha(6);
    }
}