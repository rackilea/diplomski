public Object get(Field field) {
        Object val = this.values[field.index()];
        if (val == null && field.schema().defaultValue() != null) {
            val = field.schema().defaultValue();
        }

        return val;
    }