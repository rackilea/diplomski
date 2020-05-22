protected MultiStepMockBuilder exception(RuntimeException exception) {

    mockActions.add(new ExceptionAction(exception));

    return this;

}

protected MultiStepMockBuilder resource(Resource resource) {

    mockActions.add(new ResourceAction(resource));

    return this;
}