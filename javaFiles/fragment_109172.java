public class ParentFragment extends Fragment
    implements ChildFragment.OnViewCreatedListener {

    @Override
    public void onViewCreated() {
        doStuff();
    }
}