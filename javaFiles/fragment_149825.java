public class TestActivity extends Activity {

    interface DataCallback {

        void onData(String data);

    }

    DataCallback callback;

    @Override
    protected void onResume() {
        super.onResume(savedInstanceState);

        SampleFragment fragment = SampleFragment.newInstance();
        callback = fragment.getCallback();
        getFragmentManager().beginTransaction().replace(R.id.container, fragment, "tag").commit()

    }

    public static class SampleFragment extends Fragment implements DataCallback {

        public static SampleFragment newInstance() {

            Bundle args = new Bundle();

            SampleFragment fragment = new SampleFragment();
            fragment.setArguments(args);
            return fragment;
        }

        public DataCallback getCallback() {
            return this;
        }

        @Override
        public void onData(String data) {
            //Update UI with data
        }
    }

}