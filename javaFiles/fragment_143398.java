@Inject 
Instance<MyValidatorInterface> allInstances;

public void validateAll() {
  Iterator<MyValidatorInterface> iterator = allInstances.iterator();
  while (iterator.hasNext()) {
    iterator.next().callYourValidationMethod();
  }}
}