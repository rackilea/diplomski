public class FriendsListLiveDataProvider extends ViewModel {
    private MutableLiveData<List<FriendsModel>> friendsModelLiveData;

    public LiveData<List<FriendsModel>> getFriendsModelLiveData() {
        if(this.friendsModelLiveData == null) {
            friendsModelLiveData = new MutableLiveData<>();
            friendsModelLiveData.postValue(new DaoMockFriends().getFriendsList());
        }
        return this.friendsModelLiveData;
    }
}