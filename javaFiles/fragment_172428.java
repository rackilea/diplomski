@EFragment
public class BaseFragment extends Fragment {

    @ViewById
    TextView commonView;

    @AfterViews
    void setupViews() {
        // do sg with commonView
    }
}

@EFragment(R.layout.fragment1)
public class Fragment1 extends BaseFragment {

    @ViewById
    TextView viewInFragment1;

    @Override
    void setupViews() {
        super.setupViews(); // common view is set up

        // do sg with viewInFragment1
    }
}

@EFragment(R.layout.fragment1)
public class Fragment2 extends BaseFragment {

    @ViewById
    TextView viewInFragment2;

    @Override
    void setupViews() {
        super.setupViews(); // common view is set up

        // do sg with viewInFragment2
    }
}