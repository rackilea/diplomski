public static <T> List<T>
cast(List<? super T> list, Class<T> clazz) {

        if( list.stream().allMatch( clazz::isInstance ) )
            return (List<T>) list;
        else
            throw new IllegalArgumentException ("Not all inputs are of class " + clazz.getName());
    }