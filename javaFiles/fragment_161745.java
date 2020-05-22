try {
  result = callable.call();
  // Make sure we don't return the provisioned object if there were any errors
  // injecting its field/method dependencies.
  errors.throwIfNewErrors(numErrorsBefore);
} catch(ErrorsException ee) {
  exceptionDuringProvision = ee;
  throw new ProvisionException(errors.merge(ee.getErrors()).getMessages())
}