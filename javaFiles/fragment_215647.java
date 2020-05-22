public interface BuildStep       { LineGraph        build();           }
public interface UiSwitchStep    { UiPropBuilder    uiProperties();    }
public interface XAxisSwitchStep { XAxisPropBuilder xAxisProperties(); }
public interface YAxisSwitchStep { YAxisPropBuilder yAxisProperties(); }

public interface UiPropBuilder
extends XAxisSwitchStep, YAxisSwitchStep, BuildStep {
    // UI property setters
    // ...
}

public interface XAxisPropBuilder
extends YAxisSwitchStep, UiSwitchStep, BuildStep {
    // X-axis property setters
    // ...
}

public interface YAxisPropBuilder
extends XAxisSwitchStep, UiSwitchStep, BuildStep {
    // Y-axis property setters
    // ...
}

private static class UiBuilderImpl
implements UiPropBuilder, XAxisPropBuilder, YAxisPropBuilder {
    // implement ALL property setters
    // ...

    @Override
    public XAxisProperties xAxisProperties() {
        return this;
    }
    @Override
    public YAxisProperties yAxisProperties() {
        return this;
    }
    @Override
    public UiPropBuilder uiProperties() {
        return this;
    }
    @Override
    public LineGraph build() {
        return new LineGraph(..., ..., ..., ...);
    }
}

// create new builders through a static method
// which returns the interface type
public static UiPropBuilder builder() {
    return new UiBuilderImpl();
}