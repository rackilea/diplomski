void ApplyTransparentStatusBar()
{
    Window window = getWindow();
    if (window != null)
    {
        View decor = window.getDecorView();
        if (decor != null)
            decor.setSystemUiVisibility(ResolveTransparentStatusBarFlag());
    }
}