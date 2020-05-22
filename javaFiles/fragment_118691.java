/*
    ....
        * @since 1.5
        * @jls 9.6.4.1 @Target
        * @jls 4.1 The Kinds of Types and Values
        */
public enum ElementType {
/** Class, interface (including annotation type), or enum declaration */
TYPE,

/** Field declaration (includes enum constants) */
FIELD,

/** Method declaration */
METHOD,

/** Formal parameter declaration */
PARAMETER,

/** Constructor declaration */
CONSTRUCTOR,

/** Local variable declaration */
LOCAL_VARIABLE,

/** Annotation type declaration */
ANNOTATION_TYPE,

/** Package declaration */
PACKAGE,

/**
 * Type parameter declaration
 *
 * @since 1.8
 */
TYPE_PARAMETER,

/**
 * Use of a type
 *
 * @since 1.8
 */
   TYPE_USE
}