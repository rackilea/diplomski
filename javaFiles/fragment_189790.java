public <TV> T With(Function<T, IEditable> func, TV value)
    {
        IEditable pageElement = func.apply(TypedThis);
        pageActions.Add(new WebDriverValuePageAction<TV>(pageElement, value));
        return TypedThis;
    }