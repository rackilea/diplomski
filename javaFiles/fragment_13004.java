import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Constructor;
import javax.swing.BoundedRangeModel;
import javax.swing.JSlider;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.SliderUI;

public class JSliderExt extends JSlider {

    private static final long serialVersionUID = 1L;

    public static final String EXTENT_PROPERTY = "extent";
    public static final String MAXIMUM_PROPERTY = "maximum";
    public static final String MINIMUM_PROPERTY = "minimum";
    public static final String READY_PROPERTY = "ready";
    public static final String SELECTED_VALUE_PROPERTY = "selectedValue";
    public static final String VALUE_PROPERTY = "value";

    public static final boolean READY_DEFAULT_VALUE = false;

    protected SliderUI uix = new BasicSliderUIExt(this);

    public JSliderExt(BoundedRangeModel model, boolean ready) {
        super(model);

        init(ready);
    }

    public JSliderExt(BoundedRangeModel model) {
        super(model);

        init(READY_DEFAULT_VALUE);
    }

    public JSliderExt(int orientation, int minimmum, int maximum, int value, boolean ready) {
        super(orientation, minimmum, maximum, value);

        init(ready);
    }

    public JSliderExt(int orientation, int minimmum, int maximum, int value) {
        super(orientation, minimmum, maximum, value);

        init(READY_DEFAULT_VALUE);
    }

    public JSliderExt(int minimmum, int maximum, int value, boolean ready) {
        super(minimmum, maximum, value);

        init(ready);
    }

    public JSliderExt(int minimmum, int maximum, int value) {
        super(minimmum, maximum, value);

        init(READY_DEFAULT_VALUE);
    }

    public JSliderExt(int minimmum, int maximum, boolean ready) {
        super(minimmum, maximum);

        init(ready);
    }

    public JSliderExt(int minimmum, int maximum) {
        super(minimmum, maximum);

        init(READY_DEFAULT_VALUE);
    }

    public JSliderExt(int orientation, boolean ready) {
        super(orientation);

        init(ready);
    }

    public JSliderExt(int orientation) {
        super(orientation);

        init(READY_DEFAULT_VALUE);
    }

    public JSliderExt(boolean ready) {
        super();

        init(ready);
    }

    public JSliderExt() {
        super();

        init(READY_DEFAULT_VALUE);
    }

    private void init(boolean ready) {
        UIManager.addPropertyChangeListener(new PropertyChangeListener() { // Changes the UI delegate in L&F change
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if ("lookAndFeel".equals(event.getPropertyName())) {
                    Object newValue = event.getNewValue();
                    if ((newValue != null) && (newValue instanceof LookAndFeel)) {
                        LookAndFeel lookAndFeel = (LookAndFeel) newValue;

                        try {
                            if (lookAndFeel instanceof MetalLookAndFeel) {
                                JSliderExt.this.uix = new MetalSliderUIExt();
                            } else if (lookAndFeel instanceof com.sun.java.swing.plaf.motif.MotifLookAndFeel) {
                                JSliderExt.this.uix = new MotifSliderUIExt(JSliderExt.this);
                            } else if (lookAndFeel instanceof com.sun.java.swing.plaf.windows.WindowsLookAndFeel) {
                                JSliderExt.this.uix = new WindowsSliderUIExt(JSliderExt.this);
                            } else {
                                throw new NullPointerException("Default Look & Feel not matched");
                            }
                        } catch (Exception e) {
                            try {
                                Package sliderPackage = JSliderExt.this.getClass().getPackage();
                                String lookAndFeelName = lookAndFeel.getName();
                                if (lookAndFeelName.equals("CDE/Motif")) {
                                    lookAndFeelName = "Motif";
                                } else if (lookAndFeelName.equals("Windows Classic")) {
                                    lookAndFeelName = "Windows";
                                } else if (lookAndFeelName.startsWith("JGoodies")) {
                                    lookAndFeelName = "Basic";
                                }

                                Class<?> sliderUiType = Class.forName(sliderPackage.getName() + "." + lookAndFeelName
                                        + "SliderUIExt");

                                Constructor<?> constructor1 = null;
                                try {
                                    constructor1 = sliderUiType.getConstructor(JSlider.class);
                                } catch (Exception e3) { // Nothing to do here
                                }
                                Constructor<?> constructor0 = null;
                                try {
                                    constructor0 = sliderUiType.getConstructor();
                                } catch (Exception e3) { // Nothing to do here
                                }

                                Object sliderUi = null;
                                if (constructor1 != null) {
                                    sliderUi = constructor1.newInstance(JSliderExt.this);
                                } else if (constructor0 != null) {
                                    sliderUi = constructor0.newInstance();
                                }

                                if ((sliderUi != null) && (sliderUi instanceof SliderUI)) {
                                    JSliderExt.this.setUI((SliderUI) sliderUi);
                                }
                            } catch (Exception e2) {
                                JSliderExt.this.uix = new BasicSliderUIExt(JSliderExt.this);
                            }
                        }
                    } else {
                        JSliderExt.this.uix = new BasicSliderUIExt(JSliderExt.this);
                    }
                    updateUI();
                }
            }});

        addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                String propertyName = event.getPropertyName();

                if (READY_PROPERTY.equals(propertyName)) {
                    Object newValue = event.getNewValue();

                    if ((newValue == null) || (!(newValue instanceof Boolean)) || (((Boolean) newValue).booleanValue())) {
                        setSelectedValue(Integer.valueOf(getValue()));
                    } else {
                        setSelectedValue(null);
                    }
                } else if (SELECTED_VALUE_PROPERTY.equals(propertyName)) {
                    Object newValue = event.getNewValue();
                    System.out.println(newValue);

                    if ((newValue != null) && (newValue instanceof Integer)) {
                        int value = getValue();
                        int newSelectedValue = ((Integer) newValue).intValue();

                        if (value != newSelectedValue) {
                            setValue(newSelectedValue);
                        }

                        setReady(true);
                    } else {
                        setReady(false);
                    }

                    repaint();
                } else if (VALUE_PROPERTY.equals(propertyName)) {
                    setReady(true);

                    Object newValue = event.getNewValue();

                    if ((newValue != null) && (newValue instanceof Integer)) {
                        setSelectedValue((Integer) newValue);
                    }
                }
            }});

        addKeyListener(new KeyAdapter() { // Enables escape key for clearing value
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    JSliderExt.this.setReady(false);
                }
            }});

        setReady(ready);
    }

    @Override
    public void setValue(int value) {
        int oldValue = getValue();
        super.setValue(value);
        firePropertyChange(VALUE_PROPERTY, Integer.valueOf(oldValue), Integer.valueOf(value));
    }

    @Override
    public void setExtent(int extent) {
        int oldExtent = getExtent();
        super.setExtent(extent);
        firePropertyChange(EXTENT_PROPERTY, Integer.valueOf(oldExtent), Integer.valueOf(extent));
    }

    @Override
    public void setMinimum(int minimum) {
        int oldMinimum = getMinimum();
        super.setMinimum(minimum);
        firePropertyChange(MINIMUM_PROPERTY, Integer.valueOf(oldMinimum), Integer.valueOf(minimum));
    }

    @Override
    public void setMaximum(int maximum) {
        int oldMaximum = getMaximum();
        super.setMaximum(maximum);
        firePropertyChange(MAXIMUM_PROPERTY, Integer.valueOf(oldMaximum), Integer.valueOf(maximum));
    }

    public Integer getSelectedValue() {
        return (Integer) getClientProperty(SELECTED_VALUE_PROPERTY);
    }

    public void setSelectedValue(Integer selectedValue) {
        putClientProperty(SELECTED_VALUE_PROPERTY, selectedValue);
    }

    public boolean isReady() {
        Object ready = getClientProperty(READY_PROPERTY);
        return ((ready != null) && (ready instanceof Boolean)) ? ((Boolean) ready).booleanValue()
                : READY_DEFAULT_VALUE;
    }

    public void setReady(boolean waiting) {
        putClientProperty(READY_PROPERTY, Boolean.valueOf(waiting));
    }

    @Override
    public void updateUI() {
        setUI(this.uix);
        updateLabelUIs();
    }

}