public class ParentActivity extends FragmentActivity implements OnButtonPressListener { 
@Override
    public void onButtonPressed(String msg) {
        FragmentA Obj=(FragmentA) getSupportFragmentManager().findFragmentById(R.id.framelayout);
        Obj.setMessage(msg);
    }
}