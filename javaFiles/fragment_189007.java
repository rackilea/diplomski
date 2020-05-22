private void generateListHeading(List<VacancyModel> original_vacany_list)
    {

      List<VacancyModel> vacancy_type_new_record;
     VacancyModel model = new vacacyModel();
      model.setIsHeading(true); 
      model.setHeading("New Record");
    vacancy_type_new_record.add(model);
    List<VacancyModel> vacancy_type_watched;
    model = new vacacyModel();
      model.setIsHeading(true); 
      model.setHeading("Watched");
    vacancy_type_watched.add(model);

      List<VacancyModel> new_vacancy_list;
    for(VacanyModel  data:original_vacany_list)
    {
       //do your date condition check here
       if(data.getDate==newDate)
      {
         vacancy_type_new_record.add(data) 
      } else
      {
           vacancy_type_watched.add(data) 
      }
    }
    //once the whole condition check is add both list to new list
    new_vacancy_list.addAll(vacancy_type_new_record); 
    new_vacancy_list.addAll(vacancy_type_watched); 
    //now the item count will be 32. in the format heading ,data ,heading,data
    adapter.setUpdateddata(new_vacancy_list);
      }