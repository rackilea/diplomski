public class F_ana_sayfa extends Fragment {

    ...

    SomeInterface myInterface;

    // Container activity must implement this interface
    public interface SomeInterface {
        // You can define your interface functions here
        void doSomething();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            myInterface = (SomeInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement SomeInterface");
        }
    }

    public void someFunction(boolean someBoolean) {
        if (someBoolean) {
            // Calling the interface function
            myInterface.doSomething();
        }
    }
}