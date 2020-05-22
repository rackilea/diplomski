public class FragmentA extends Fragment {
    private String mName;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentB fragmentB = new FragmentB();
        fragmentB.setTargetFragment(this, 1111);
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}

public class FragmentB  extends Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((FragmentA)getTargetFragment()).setmName("xyz");
    }
}