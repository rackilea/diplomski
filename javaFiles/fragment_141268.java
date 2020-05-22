public class CustomWebView extends WebView
{
    private Surface _webViewSurface;

    public void setWebViewSurface(Surface webViewSurface)
    {
        _webViewSurface = webViewSurface;
    }

    @Override
    public void draw(Canvas canvas) {
        if (_webViewSurface == null)
        {
            super.draw(canvas);
            return;
        }

        // Returns canvas attached to OpenGL texture to draw on
        Canvas glAttachedCanvas = _webViewSurface.lockCanvas(null);

        if (glAttachedCanvas != null)
        {
            // Draw the view to provided canvas
            super.draw(glAttachedCanvas);
        }
        else
        {
            super.draw(canvas);
            return;
        }

        _webViewSurface.unlockCanvasAndPost(glAttachedCanvas);
    }
}