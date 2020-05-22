package example;
    @Deprecated
class CorrectClassDefA {}

@Deprecated class IncorrectClassDefA {}

abstract
@Deprecated
class CorrectClassDefB {}

abstract @SuppressWarnings(value = "unused") class IncorrectClassDefB0 {}

abstract
    @Deprecated class IncorrectClassDefB1 {}

abstract@Deprecated
class IncorrectClassDefB2 {}

@Deprecated abstract class IncorrectClassDefB3 {}

@Deprecated
abstract class CorrectClassDefB4 {}

@SuppressWarnings(value = "unused")
interface CorrectInterfaceDefA {}

@Deprecated interface IncorrectInterfaceDefA {}

abstract
@Deprecated
interface CorrectInterfaceDefB {}

abstract @Deprecated interface IncorrectInterfaceDefB0 {}

abstract
@Deprecated interface IncorrectInterfaceDefB1 {}

abstract @SuppressWarnings(value = "unused")
interface IncorrectInterfaceDefB2 {}

@SuppressWarnings(value = "unused") abstract interface IncorrectInterfaceDefB3 {}

@SuppressWarnings(value = "unused")
abstract 
interface CorrectInterfaceDefB4 {}

@Deprecated
enum CorrectEnumA {
    @SuppressWarnings(value = "unused")
    CORRECT,
    @Deprecated INCORRECT }

@Deprecated enum 
IncorrectEnumA {
@Deprecated
    CORRECT,
    @SuppressWarnings(value = "unused") INCORRECT }


public class AnnotatedClass { @Deprecated // incorrect
    public AnnotatedClass() {}

    @Deprecated
    AnnotatedClass(int correct) {}

    public
    @SuppressWarnings(value = "unused")
    AnnotatedClass(boolean correct, boolean correct0) {}

    @SuppressWarnings(value = "unused")
    AnnotatedClass(int correct, int correct0, int correct1) {}

    public @SuppressWarnings(value = "unused")
    AnnotatedClass(@Deprecated int bad, int bad0, int bad1, int bad2) {}

    @SuppressWarnings(value = "unused") AnnotatedClass(@Deprecated int bad, int bad0, int bad1, int bad2, int bad3) {}

    @Deprecated private int incorrectB;

    transient @Deprecated 
    private int incorrectC;

    transient
    @Deprecated 
    private 
    int correctD;

    private
    @SuppressWarnings(value = "unused")
    Object correctA; @SuppressWarnings(value = "dog")
     public void incorrectA(final Object baz) {
    }

    public void correctB(@SuppressWarnings(value = "dog") final Object good) {
        @Deprecated
        int correctA;

        final @Deprecated int incorrectB;

        final
        @Deprecated
        Object
        correctC;
    }

    @SuppressWarnings(value = "dog") public 
    void incorrectC(final Object bad) {
    }

    public
    @SuppressWarnings(value = "dog") void incorrectD(final Object bad) {
    }
}