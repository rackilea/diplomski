package javax.annotation;

import java.lang.annotation.*;

/**
 * Overriding-Methods-Must-Invoke-Super annotation.
 * See JSR 305: Annotations for Software Defect Detection
 *              (https://jcp.org/en/jsr/detail?id=305)
 */
@Retention( RetentionPolicy.CLASS )
@Target( ElementType.METHOD )
public @interface OverridingMethodsMustInvokeSuper
{
}