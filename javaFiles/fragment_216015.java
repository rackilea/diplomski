class Parameter<T> {
    String name;
    T defaultValue;
}

class ParameterComponent<P extends Parameter> {
    void setParameter(final P p) {}
}

interface ParameterComponentFactory<P extends Parameter> {
    ParameterComponent<P> newComponent();
}

class FloatParameter extends Parameter<Float> {}
class FloatParameterComponent extends ParameterComponent<FloatParameter> {}

class EnumParameter extends Parameter<Enum> {}
class EnumParameterComponent extends ParameterComponent<EnumParameter> {}