@Override
public Activity getActivity(Place place) {
    if (!(place instanceof ProxyListPlace)) {
        return null;
    }
    Activity activity = super.getActivity(place);
    if (activity == null) {
        ProxyListPlace listPlace = (ProxyListPlace) place;
            if (SomeEntityProxy.class.equals(listPlace.getProxyClass())) {
                 activity = new SomeActivity();
            }
     }
     return activity;
}