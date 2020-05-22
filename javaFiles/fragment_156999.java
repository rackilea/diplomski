public class SetToListELResolver extends ListELResolver {

    public static final String KEY_PROPERTY = "setToList";

    @Override
    public Object getValue(ELContext context, Object base, Object property) {
        if (base instanceof Set<?> && KEY_PROPERTY.equals(property)) {
            context.setPropertyResolved(true);
            return new ArrayList<Object>((Set<?>) base);
        }

        return super.getValue(context, base, property);
    }

}