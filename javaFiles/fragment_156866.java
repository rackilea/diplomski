public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CardsService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CardsService service = retrofit.create(CardsService.class);

        Call<MainCard> call = service.getCards();

        call.enqueue(new Callback<MainCard>() {
            @Override
            public void onResponse(Call<MainCard> call, Response<MainCard> response) {
                if (response.isSuccessful()) {
                    // Got a successful response (Code 200...300)

                    MainCard mainCard = response.body();

                    if (mainCard != null && mainCard.cards != null) {
                        List<Item> recentlyUpdates = mainCard.cards.recentlyUpdates;
                        List<Item> newlyArrives = mainCard.cards.newlyArrives;

                        // Use your information to set up the recyclerview as the tutorial you
                        // showed describe.
                        setupRecyclerView(recentlyUpdates, newlyArrives);
                    }
                } else {
                    // Got a unsucessful response (Code 401, 405, 409...)
                }
            }

            @Override
            public void onFailure(Call<MainCard> call, Throwable t) {
                // Failed to connect to the server
                // Possible causes: No internet connection, Server is broken.
            }
        });
    }
}