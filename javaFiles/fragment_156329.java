private void a (Fragment frag, Class<? extends Fragment> clazz) {

    try {
        if (frag == null) {

            frag = getFragmentManager().findFragmentByTag(clazz.getField("TAG").get(null).toString());

            if (frag == null) {
                frag = clazz.newInstance();
            }
        }
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (NoSuchFieldException e) {
        e.printStackTrace();
    }
    addFragment(frag);
}