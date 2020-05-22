public String render(ProxyListPlace object) {
    return new ApplicationEntityTypesProcessor<String>() {

        @Override
        public void handlePet(PetProxy isNull) {
            setResult("Pets");
        }

        @Override
        public void handleOwner(OwnerProxy isNull) {
            setResult("Owners");
        }
    }.process(object.getProxyClass());
}