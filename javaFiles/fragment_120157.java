public void foo() {
    bar(this.structure);
}

private <T extends BaseRequest> void bar(Structure<T> s) {
    for (T request : s.getElementsList()) {
        Collection<T> requests = s.getDependencies(request);

        // do things
    }
}