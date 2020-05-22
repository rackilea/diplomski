class CreatingGenericEnumSet<E extends Enum<E> & CommonEnumInterface<E>> {

    CreatingGenericEnumSet(Class<E> enumClass) {

        EnumSet<E> enumSet = EnumSet.<E>noneOf(enumClass);


    }
}