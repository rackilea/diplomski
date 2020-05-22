mentorViewModel.getAllMentors().observe(this, new Observer<List<Mentor>>() {
    @Override
    public void onChanged(@Nullable List<Mentor> mentorList) {
        if (mentorList != null) {
            for (Mentor m : mentorList) {
                mentorNameList.add(m.getMentor_name());
                mentorListMentor.add(m);
            }
            lookForMentor();
        }
    }
});

private void lookForMentor() {
   for(Mentor m: mentorListMentor){
    if (m.getMentor_id()==mentorId){
        String test = m.getMentor_name();
        int spinnerSelectionM2 = getIndexM(sp_CourseMentor, test);
        sp_CourseMentor.setSelection(spinnerSelectionM2);
    }
  }
}