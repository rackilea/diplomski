aspect AspectExample {
    before() : execution(* Point.*(..))
    {
         logger.entering(thisJoinPointStaticPart.getSignature().getName(), thisJoinPointStaticPart.getSignature().getDeclaringType()   );

    }

    after() : execution(* Point.*(..))
    {
         logger.exiting(thisJoinPointStaticPart.getSignature().getName() , thisJoinPointStaticPart.getSignature().getDeclaringType()  );

    }
}