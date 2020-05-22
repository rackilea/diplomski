public class homepageActivity ... {

    // 1. Change this to a CardAdapter
    private CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...

        // 2. Change this to reference the field adapter.
        adapter = new CardAdapter(getHeader(),listSuperHeroes, this);
    }
}