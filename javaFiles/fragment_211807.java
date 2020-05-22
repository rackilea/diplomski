// Try and get a pre-loaded icon
Icon controlIcon = icons.get(controlName);
// It wasn't there, try loading it
if (controlIcon == null)
{
    loadIcon(controlName);
    controlIcon = icons.get(controlName);
}