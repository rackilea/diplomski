public interface FaderListener {
    public void fadeDidComplete(FadePane pane);
}

public class FadePane extends JPanel {

    private double alpha = 1;
    private boolean fadingIn = true;
    private DoubleAnimatable animatable;
    private Duration duration = Duration.ofSeconds(5);
    private List<FaderListener> listeners = new ArrayList<>(5);

    public FadePane() {
        setOpaque(false);
    }

    public void addFadeListener(FaderListener listener) {
        listeners.add(listener);
    }

    public void removeFadeListener(FaderListener listener) {
        listeners.remove(listener);
    }

    public boolean isFadingIn() {
        return fadingIn;
    }

    public double getAlpha() {
        return alpha;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive((float)getAlpha()));
        g2d.setColor(getBackground());
        g2d.fillRect(0, 0, getWidth(), getHeight());
        super.paint(g2d);
        g2d.dispose();
    }

    protected void fadeTo(double to) {
        double currentAlpha = getAlpha();
        if (animatable != null) {
            animatable.stop();
            animatable = null;
        }

        if (currentAlpha == to) {
            fadeDidComplete();
            return;
        }

        DoubleRange animationRange = new DoubleRange(currentAlpha, to);
        double maxFrom = to == 1 ? 1 : 0;
        double maxTo = to == 1 ? 0 : 1;
        DoubleRange maxRange = new DoubleRange(maxFrom, maxTo);

        animatable = new DoubleAnimatable(animationRange, maxRange, duration, new AnimatableListener<Double>() {
            @Override
            public void animationChanged(Animatable<Double> animatable) {
                alpha = animatable.getValue();
                repaint();
            }
        }, new AnimatableLifeCycleListenerAdapter<Double>() {
            @Override
            public void animationCompleted(Animatable<Double> animatable) {
                fadeDidComplete();
            }
        });

        Animator.INSTANCE.add(animatable);
    }

    public void fadeIn() {
        fadingIn = true;
        fadeTo(1);
    }

    public void fadeOut() {
        fadingIn = false;
        fadeTo(0);
    }

    protected void fadeDidComplete() {            
        for (FaderListener listener : listeners) {
            listener.fadeDidComplete(this);
        }
    }

}