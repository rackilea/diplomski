MutableLiveData userIdLiveData = ...;
 LiveData userLiveData = Transformations.switchMap(userIdLiveData, id ->
     repository.getUserById(id));

 void setUserId(String userId) {
      this.userIdLiveData.setValue(userId);
 }