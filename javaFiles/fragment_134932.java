public <U extends IComponent> U GetComponent(Class<U> clazz) {
        for (IComponent component : list) {
            if (clazz.isInstance(component)) {
                return clazz.cast(component);
            }
        }
    }