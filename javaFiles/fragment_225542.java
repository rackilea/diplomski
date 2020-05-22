package de.fhb.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareError;

@Aspect
public class ReturnTypeChecker {
    @DeclareError("within(de.fhb..*) && execution(java.util.List+ *(..)) && !execution(java.util.List *(..))")
    private static final String typeWarning = "Please do not declare methods returning concrete subclasses of List";
}