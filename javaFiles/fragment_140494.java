class EventViewModel extends AndroidViewModel {
  private MutableLiveData<Obj> liveObjects = new MutableLiveData<>();

  LiveData<Obj> getObjects() {
    return liveObjects;
  }

  public void loadObject(){
     new Thread(new Runnable() {
        @Override
        public void run() {
          Obj object = // TODO get the value

          liveObjects.postValue(object);
        }
      }).start();
  }
}

public class EventFragment extends Fragment {

 private EventViewModel vm;

 @Override
 public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    vm = ViewModelProviders.of(this).get(EventViewModel.class);

    vm.getObjects().observe(this, new Observer<Obj>() {
        @Override
        public void onChanged(@Nullable final Obj newValue) {
            // TODO something useful
        }
    });
}