private Map<String, Object> toMap(final EmployeeEntity employeeEntity,
        final String... fieldNamesToExtract) {

    final Map<String, Object> employeeMap = new HashMap<>();

    final Class<? extends EmployeeEntity> employeeEntityClass = employeeEntity.getClass();

    for (final String fieldName : fieldNamesToExtract) {

        try {

            final Field declaredField = employeeEntityClass.getDeclaredField(fieldName);

            declaredField.setAccessible(true); // because the fields are private

            employeeMap.put(declaredField.getName(), declaredField.get(employeeEntity));
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {

            System.out.println("e = " + e);

            throw new RuntimeException(e);
        }
    }

    return employeeMap;
}