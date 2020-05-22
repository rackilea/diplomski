private void a (Fragment frag, Class<? extends Fragment> clazz, String tag) {
    if (frag == null) {
        frag = getFragmentManager().findFragmentByTag(tag);
        if (frag == null) {
            try {
                frag = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    addFragment(frag);
}