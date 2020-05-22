@Override
public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Bundle extras = getArguments();

    if (extras == null) {
   //maybe throw an exception, as this should never happen
    } else {
      Integer roomConfig = extras.getInt("room_config");
      Integer roomId = extras.getInt("room_id");
    }

}