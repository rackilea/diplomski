public class DetailsFirstTabViewModel extends AndroidViewModel {
    private MutableLiveData<List<ThingEntity>> things = new MutableLiveData<>();

    ...

    public MutableLiveData<List<ThingEntity>> getThings() {
        return things;
    }

    public void getAllThings(int minValue) {
        things.postValue(repository.getAllThings(minValue).getValue());
    }
}