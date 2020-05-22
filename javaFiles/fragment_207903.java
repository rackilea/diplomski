interface A<T>{
    default void foo(Object t){
        System.err.println(new Exception().getStackTrace()[0] + " " + t);
    }
}

interface B<T extends SomeConcreteType> extends A<T>{
    @Override
    default void foo(Object t){ 
        this.foo((SomeConcreteType) t);
    }

    default void foo(SomeConcreteType t){
        System.err.println(new Exception().getStackTrace()[0] + " " + t);
    }
}