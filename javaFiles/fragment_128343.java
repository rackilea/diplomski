switchExam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            StringBuilder upcoming = new StringBuilder("Upcoming\n\n");
            StringBuilder Results = new StringBuilder("Results\n\n");
            float v= 0;
            if(!isChecked)
            {

                for(FAssessment a : assessmentList) {
                    if(!a.getType().equals("Final"))
                    {
                        double d = CalculatePercentage(a.getTotal(),a.getAchieved(),Double.parseDouble(a.getWeight()));
                        v += (float) d;
                    }

                    upcoming.append(a.getDesc()+" "+a.getDate()+"\n");
                    Results.append(a.getDesc()+" "+format.format(((a.getAchieved()/a.getTotal())*100))+"%\n");
                }                    
                SetInit(v,upcoming,Results);
            }
            else
            {
                for(FAssessment a : assessmentList) {
                    double d = CalculatePercentage(a.getTotal(),a.getAchieved(),Double.parseDouble(a.getWeight()));
                    v += (float) d;
                    upcoming.append(a.getDesc()+" "+a.getDate()+"\n");
                    Results.append(a.getDesc()+" "+format.format(((a.getAchieved()/a.getTotal())*100))+"%\n");
                }
                SetInit(v,upcoming,Results);

            }
        }
    });
    switchExam.setChecked(true);