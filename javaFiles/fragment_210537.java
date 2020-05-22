public class MyActivity extends FragmentActivity implements MyInterface{

    @Override
    public void changeUI(String sometext) {
        Fragment1 fragment1 = (Fragment1) getFragmentManager().findFragmentByTag("tagCommittedFragment1");
        fragment1.applyChange(sometext);
    }

}

public class Fragment0 extends Fragment{

    MyInterface mMyInterface;

    public interface MyInterface {
        public void changeUI(String sometext);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mMyInterface = (MyInterface) activity;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);          
        mMyInterface.changeUI("newtext");
    }

}

public class Fragment1 extends Fragment{
    public void applyChange(String sometext){
        // do your work
    }
}