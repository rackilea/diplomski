public class YourFragment extends android.support.v4.app.Fragment {

    // TODO: Implement onCreateView

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 // Handle click
            }
        });
}