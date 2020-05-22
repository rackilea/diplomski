public static AbstractWidget getWidget(ObjectType widgetType) {
    return widgetType.instantiate();
}

public enum ObjectType {
    X {
        @Override
        XWidget instantiate() {
            return new XWidget();
        }
    },
    Y {
        @Override
        YWidget instantiate() {
            return new YWidget();
        }
    };
    abstract AbstractWidget instantiate();
}