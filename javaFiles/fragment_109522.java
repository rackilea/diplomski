mentorsViewModel.getAllMentors();
mentorViewModel.mentorsLiveData.observe(this, new Observer<List<Mentor>>() {
        @Override
        public void onChanged(@Nullable List<Mentor> mentorList) {
              mentorsListMentor.addAll(mentorList);
              sp_CourseMentorAdapter.notifyDataSetChanged();
              for(Mentor m: mentorListMentor){
                 if (m.getMentor_id()==mentorId){
                   String test = m.getMentor_name();
                   int spinnerSelectionM2 = getIndexM(sp_CourseMentor, test);
                   sp_CourseMentor.setSelection(spinnerSelectionM2);
                }
             }
            }
        }
    });