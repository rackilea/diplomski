public class CGLIBEnhancerEnhancer implements TypeEnhancer {
    public void Object enhance(Object objectCandidateToEnhance, MethodInterceptor interceptor) {
        Class classCandidateToEnhance = classCandidateToEnhance.getClass();
        if(Enhancer.isEnhanced(classCandidateToEnhance)
           || Mockito.mockingDetails(objectCandidateToEnhance).isMock()) {
            // safe with CGLIB (2.x) enhanced class 
            return (Bar) Enhancer.create(
                    classCandidateToEnhance.getSuperclass(),
                    classCandidateToEnhance.getInterfaces(),
                    interceptor
                );
        } else
            return (Bar) Enhancer.create(classCandidateToEnhance, interceptor);
        }
    }
}