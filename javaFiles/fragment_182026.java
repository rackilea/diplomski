public void configureAndShowFragment(BaseFragment fragment, int layout) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (fragment == null) {
            throw new RuntimeException("fragment cannot be null");
        }

        String fragmentClassName = fragment.getClass().getName();

        fragment = (BaseFragment) getSupportFragmentManager().findFragmentById(layout);
        if (fragment == null && findViewById(layout) != null) {
            Class<?> clazz = Class.forName(fragmentClassName);
            Constructor<?> ctor = clazz.getConstructor();
            fragment = (BaseFragment) ctor.newInstance(); <== init fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(layout, fragment)
                    .commit();
        }
    }