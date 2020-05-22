public Activity getActivity(Place place) {
    if (!(place instanceof ProxyListPlace)) {
        return null;
    }
    ProxyListPlace listPlace = (ProxyListPlace) place;
    return new ApplicationEntityTypesProcessor<Activity>() {

        @Override
        public void handlePet(PetProxy isNull) {
            setResult(new PetListActivity(requests, ScaffoldApp.isMobile() ? PetMobileListView.instance() : PetListView.instance(), placeController));
        }

        @Override
        public void handleOwner(OwnerProxy isNull) {
            setResult(new OwnerListActivity(requests, ScaffoldApp.isMobile() ? OwnerMobileListView.instance() : OwnerListView.instance(), placeController));
        }
    }.process(listPlace.getProxyClass());
}