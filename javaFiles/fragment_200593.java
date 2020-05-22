public interface OnBackPressed {
        void onBackPressed();
    }

    public class BaseFragment extends Fragment implements OnBackPressed {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return super.onCreateView(inflater, container, savedInstanceState);
        }

@Override
public void onBackPressed() {
     // do what you want to save
       saveNote()}
    }