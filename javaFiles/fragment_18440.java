package com.sample;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.annotation.meta.TypeQualifierDefault;

/**
 * This annotation can be applied to a package or class to indicate that the 
 * classes' methods in that element all return nonnull values by default
 * unless there is
 * <ul>
 *   <li>an explicit nullness annotation
 *   <li>a default method annotation applied to a more tightly nested element.
 * </ul>
 */
@Documented
@Nonnull
@TypeQualifierDefault(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReturnValuesAreNonnullByDefault {
    // feel free to name it MethodsAreNonnullByDefault; I find that confusing
}