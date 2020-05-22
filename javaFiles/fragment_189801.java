public aspect AnnotatedParentPointcutAspect {   

//introducing empty marker interface
declare parents : (@MyAnnotation *) implements TrackedParentMarker;

public pointcut p1() : execution(* TrackedParentMarker+.*(..));

before(): p1(){
    System.out.println("Crosscutted method: "
            +thisJoinPointStaticPart.getSignature().getDeclaringTypeName()
            +"." 
            +thisJoinPointStaticPart.getSignature().getName());
}
}