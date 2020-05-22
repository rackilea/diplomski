public interface MyType {

    public boolean isSubclassOf(MyType otherType);

}

public class MyTypeClassImpl implements MyType {

    private Class<?> clazz;

    public MyTypeClassImpl(Class<?> clazz) {
        this.clazz = clazz;
    }

    public boolean isSubclassOf(MyType otherType) {
        if(otherType instanceof MyTypeClassImpl) {
            return clazz.isAssignableFrom(((MyTypeClassImpl)otherType).clazz);
        } else {
            throw new RuntimeException("TypeMirror encountered in non-annotation-processing environment");
        }
    }

}

//Similar implementation for type mirrors

public interface TypeFactory {

    public MyType fromJavaType(Object type);

}

public class AnnotationProcessorTypeFactory {

    private ProcessingEnvironment processingEnv;

    public MyType fromJavaType(Object type) {
        if(type instanceof TypeMirror) {
            return MyTypeMirrorImpl((TypeMirror)type);
        } else if (type instanceof Class<?>) {
            return MyTypeMirrorImpl(convertToTypeMirror((Class<?>)type));
        }
    }

    private TypeMirror convertToTypeMirror(Class<?> clazz) {
        return processingEnv.getElementUtils().getTypeElement(clazz.getCanonincalName());
    }

}

public class RuntimeTypeFactory implements TypeFactory {

    public MyType fromJavaType(Object type) {
        if(!(type instanceof Class<?>)) {
            throw new RuntimeException("Illegal use of non-class type in runtime environment");
        }
        return new MyTypeClassImpl((Class<?>)type);
    }

}