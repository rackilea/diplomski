public class InstanceofExpression extends BinaryExpression<Object> {

    @Override
    public Object evaluate(PebbleTemplateImpl self, EvaluationContextImpl context) {
        // The left class (left instanceof right)
        Object leftClass = getLeftExpression().evaluate(self, context);

        // The right class, this is a string with the full qualifying name of the class eg (left
        // instanceof "java.lang.String")
        String rightClassname = getRightExpression().evaluate(self, context).toString();

        // We must get the right class as Class<?> in order to check if left is an instanceof right
        Class<?> rightClass;
        try {
            rightClass = Class.forName(rightClassname);
        } catch (ClassNotFoundException e) {
            throw new PebbleException(e.getCause(),
                    String.format("Cannot find class %s", rightClassname));
        }

        // Check if the left class is an instanceof the right class
        return rightClass.isInstance(leftClass);
    }

}