MentorViewModel extends ViewModel {
   private MutableLiveData<List<Mentor>> _mentorsLiveData = new MutableLiveData<List<Mentor>>();
   public LiveData<List<Mentor>> mentorsLiveData = (LiveData) _mentorsLiveData;

 void getAllMentors(){
    //room db query
    _mentorsLiveData.postValue(mentorsList);
 }
}