public class MyFragment extends Fragment implements View.OnClickListener {

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    view.findViewById(R.id.my_layout).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    // Handle click based on v.getId()
  }

}