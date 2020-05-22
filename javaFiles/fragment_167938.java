getAsString(FacesContext ctx, UIComponent component, Object value) {
    if (value is NaN) {
        return your-own-NaN-string;
    }

    if (value is infinity) {
        return your-own-infinity-string;
    }

    return super.getAsNumber(ctx, component, value);
}