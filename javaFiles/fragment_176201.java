public class ChallengesListFragment extends BaseFragment implements OnRefreshListener, Paginate.Callbacks { 

// other variables..
  private int currentPage = 1;
  private boolean hasMore;
  private boolean loadingInProgress;


  @RequiresApi(api = VERSION_CODES.LOLLIPOP)
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_challenges_list, container, false);
    initView(rootView);
    initToolbar();
    initRecycler();
    getData();

    return rootView;
  }

  private void initRecycler() {
    data = new ArrayList<>();
    mLayoutManager = new LinearLayoutManager(getActivity());
    recyclerview.setLayoutManager(mLayoutManager);
    adapter = new ChallengesAdapter(data, getActivity(), this);
    recyclerview.setAdapter(adapter);

    Paginate.with(recyclerview, this)
        .setLoadingTriggerThreshold(3)
        .addLoadingListItem(false)
        .build();
  }

  private void getData() {

     swipeRefresh.setRefreshing(true);
    WebRequests.GetActiveChallenges(currentPage, new onResult() {
      @Override
      public void onSuccess(Object object) {

        ArrayList<Challenge> list = (ArrayList<Challenge>) object;
        data.addAll(list);
        adapter.notifyDataSetChanged();

        if (list.size() == 10) {
          currentPage++;
          hasMore = true;
        } else {
          hasMore = false;
        }
        loadingInProgress = false;
        swipeRefresh.setRefreshing(false);


      }

      @Override
      public void onFail(Object object) {
        Toast.makeText(getActivity(), "Something went wrong, try again later",
            Toast.LENGTH_SHORT).show(); 
        swipeRefresh.setRefreshing(false);

      }
    });

  } 

  public ChallengesListFragment() {
   } 

  @Override
  public void onRefresh() {
    currentPage = 1;
    loadingInProgress = true;
    getData();
   }

  @Override
  public void onLoadMore() {
    loadingInProgress = true;
     Handler mHandler = new Handler();
    final Runnable hintRunnable = new Runnable() {
      @Override
      public void run() {
        getData();
      }
    };
    mHandler.postDelayed(hintRunnable, 1500);

  }

  @Override
  public boolean isLoading() {
    return loadingInProgress;
  }

  @Override
  public boolean hasLoadedAllItems() {
    return !hasMore;
  } 

}