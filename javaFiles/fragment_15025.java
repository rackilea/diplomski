public class ObjectIdFactory implements BeanFactory {
    @Override
    public Object createBean(Object source, Class<?> sourceClass, String targetBeanId) {
        if (source == null) {
            return null;
        }
        if (source instanceof ObjectId) {
            return source; // we can return source, because it's immutable
        }
        if (source instanceof String) {
            return new ObjectId((String) source);
        }
        if (source instanceof FileDataDto) {
            return new ObjectId(((FileDataDto) source).getId());
        }
        throw new MappingException("ObjectId should be of type ObjectId, String or FileDataDto");
    }
}