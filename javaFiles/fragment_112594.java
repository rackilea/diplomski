abstract class RenderView {

    public abstract void doSomething();
}

class DefaultRenderView {

    private SurfaceView mView;

    public DefaultRenderView(SurfaceView view) {
        mView = view;
    }

    public void doSomething() {
        // SurfaceView specific code
    }
}

class TextureRenderView {

    private TextureView mView;

    public TextureRenderView(TextureView view) {
        mView = view;
    }

    public void doSomething() {
        // TextureView specific code
    }
}

RenderView renderView;

if (DeviceVersion.atLeast(API_14)) {
    renderView = new TextureRenderView(
        (TextureView) root.findViewById(R.id.texture_view));
}
else {
    renderView = new DefaultRenderView(
        (SurfaceView) root.findViewById(R.id.texture_view));
}