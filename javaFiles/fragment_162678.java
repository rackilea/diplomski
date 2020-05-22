interface IValidatorFactory {
    public <T extends XmlBean> Validator<T> getValidator(Class<T> clazz);
}

class ValidatorFactory implements IValidatorFactory {
    private final Map<Class<? extends XmlBean>, Validator<? extends XmlBean>> map =
        new HashMap<Class<? extends XmlBean>, Validator<? extends XmlBean>>();

    @SuppressWarnings("unchecked")
    @Override
    public <T extends XmlBean> Validator<T> getValidator(Class<T> clazz) {
        return (Validator<T>)map.get(clazz);
    }

    public <T extends XmlBean> void registerValidator(Class<T> clazz, Validator<T> validator) {
        map.put(clazz, validator);
    }
}