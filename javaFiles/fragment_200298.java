@Factory
public Object[] factory() {

    DataLoader loader = new DataLoader();
    Object[] validators = new Object[10];
    for (int i = 0; i < validators.length; i++) {
        validators[i] = new ValidationTest(i, loader);
    }

    return validators;
}