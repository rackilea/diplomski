public class GetByOwnerStrategy implements AccessDecisionStrategy {
    @Override
    public void decide(Authentication authentication,
            MethodInvocation methodInvocation, ConfigAttribute configAttribute) {

        MethodInvocationExtractor<Object> extractor = new MethodInvocationExtractor<>(methodInvocation);
        Person person = (Person) extractor.getArg(0);
        String userId = (String) extractor.getArg(1);

        String username = authentication.getName();

        if (! ((userId.equals(username)) && (person.getSomeData().equals("SOMETHING") ) && ....) {
            throw new AccessDeniedException("Not enough privileges");
        }
    }
}