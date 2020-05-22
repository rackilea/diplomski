public class ViewModelParameterizedProvider {

    private AtomicBoolean set = new AtomicBoolean(false);

    private ViewModelStore viewModelStore = null;


    static ViewModelParameterizedProvider getProvider() {
        return new ViewModelParameterizedProvider();
    }

    @MainThread
    public static ViewModelProvider ofSupportFragment(Fragment fragment, Object... params) {
        return getProvider().of(fragment).with(params);
    }

    @MainThread
    public static ViewModelProvider ofActivity(FragmentActivity fragmentActivity, Object... params) {
        return getProvider().of(fragmentActivity).with(params);
    }

    @MainThread
    public static ViewModelProvider ofFragment(android.app.Fragment fragment, Object... params) {
        return getProvider().of(fragment).with(params);
    }

    private ViewModelParameterizedProvider of(Fragment fragment) {
        checkForPreviousTargetsAndSet();
        viewModelStore = ViewModelStores.of(fragment);
        return this;
    }

    private ViewModelParameterizedProvider of(android.app.Fragment fragment) {
        FragmentActivity fragAct = (FragmentActivity) fragment.getActivity();
        return of(fragAct);
    }

    private ViewModelParameterizedProvider of(FragmentActivity activity) {
        checkForPreviousTargetsAndSet();
        viewModelStore = ViewModelStores.of(activity);
        return this;
    }


    private ViewModelProvider with(Object... constructorParams) {
        return new ViewModelProvider(viewModelStore, parametrizedFactory(constructorParams));
    }


    private void checkForPreviousTargetsAndSet() {
        if (set.get()) {
            throw new IllegalArgumentException("ViewModelStore already has been set. Create new instance.");
        }
        set.set(true);
    }

    private ViewModelProvider.Factory parametrizedFactory(Object... constructorParams) {
        return new ParametrizedFactory(constructorParams);
    }


    private final class ParametrizedFactory implements ViewModelProvider.Factory {
        private final Object[] mConstructorParams;

        ParametrizedFactory(Object... constructorParams) {
            mConstructorParams = constructorParams;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            if (modelClass == null) {
                throw new IllegalArgumentException("Target ViewModel class can not be null")
            }
            Log.w("ParametrizedFactory", "Don't use callbacks or Context parameters in order to avoid leaks!!")
            try {
                if (mConstructorParams == null || mConstructorParams.length == 0) {
                    return modelClass.newInstance();
                } else {
                    Class<?>[] classes = new Class<?>[mConstructorParams.length];
                    for (int i = 0; i < mConstructorParams.length; i++) {
                        classes[i] = mConstructorParams[i].getClass();
                    }
                    return modelClass.getConstructor(classes).newInstance(mConstructorParams);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}