aspect AspectExample {
    before() : execution(* aspects.trace.demo.*.*(..))
    {
         logger.entering(thisJoinPointStaticPart.getSignature().getName(), thisJoinPointStaticPart.getSignature().getDeclaringType()   );

    }

    after() : execution(* aspects.trace.demo.*.*(..))
    {
         logger.exiting(thisJoinPointStaticPart.getSignature().getName() , thisJoinPointStaticPart.getSignature().getDeclaringType()  );

    }
}