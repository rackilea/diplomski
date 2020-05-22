public class CleverFragment extends Fragment {
    WebView webview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clever, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        webview = view.findViewById(R.id.clever_web);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://google.com");
    }
}