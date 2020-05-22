@Override
public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
    if (modelValue == null) {
        return "";
    }

    if (modelValue instanceof Doctor) {
        Long id = ((Doctor) modelValue).getId();
        return (id != null) ? String.valueOf(id) : null;
    } else {
        throw new ConverterException(new FacesMessage(modelValue + " is not a valid Doctor"));
    }
}

@Override
public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
    if (submittedValue == null || submittedValue.isEmpty()) {
        return null;
    }

    try {
        Long id = Long.valueOf(submittedValue);
        return doctorService.find(id);
    } catch (NumberFormatException e) {
        throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Doctor ID"));
    }
}