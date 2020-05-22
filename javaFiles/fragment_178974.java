public class CardFragmentUsers extends Fragment implements CardFragment {

    private CardView cardView;
    ArrayList<User> users = new ArrayList<User>();
    UsersListViewAdapter usersListViewAdapter;
    TextView userCardviewGuideText;

   // ...
   // Your code

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        // ...
        // Your code

        // Define the TextView here
        userCardviewGuideText = findViewById(R.id.userCardviewGuideText);

        // Create your adapter outside the listener
        usersListViewAdapter = new UsersListViewAdapter(getContext(), users);
        ListView usersListView = (ListView) view.findViewById(R.id.usersListView);
        usersListView.setAdapter(usersListViewAdapter);

        usersApplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (InternetConnection.checkConnection(getContext())) {
                    retrieveUserInfoFromApi(); // Using a separate method make the code clearer

                } else {
                    Toast.makeText(getActivity(), getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
                    userCardviewGuideText.setVisibility(View.VISIBLE);
                }

            }
        });

        return view;
    }


    public CardView getCardView() {
        return cardView;
    }

    public void retrieveUserInfoFromApi() {
        ApiService api = RetroClient.getApiService();

        Call<User> call = api.getUser(1);
        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    userCardviewGuideText.setVisibility(View.INVISIBLE);
                    User user = new User();
                    user.setName(response.body().getName());
                    user.setUsername(response.body().getUsername());
                    users.add(user);
                    // Notify the adapter that the data have changed
                    usersListViewAdapter.notifyDataSetChanged();
                } else {
                    // ...
                    // Your code
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Do something on error
            }
        });
    }
}