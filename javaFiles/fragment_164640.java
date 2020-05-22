public static Fragment newInstance(final String eventName,final String eventDescr, final int drawableId) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_STRING_KEY, stringId);
        bundle.putInt(BUNDLE_DRAWABLE_KEY, drawableId);
        bundle.putString(BUNDLE_STRING_DESC_KEY,descStringId);
        Fragment fragment = new DynamicEventsPage();
        fragment.setArguments(bundle);
        return fragment;
}