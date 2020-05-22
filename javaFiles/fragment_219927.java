public void deleteObjFormList(JobFitSurveyConfigVO emp,List<JobFitSurveyConfigVO> emps)
    {
        int i = emps.indexOf(emp);
        emps.remove(i);
        for(int j=i;j<emps.size();j++)
        {
            JobFitSurveyConfigVO emp1 = emps.get(j);
            emp1.setSequenceNumber(emp1.getSequenceNumber()-1);
        }
        return;
    }