Specification<AccountRight> searchSpec = CommonUtil.buildSearchSpecification(search); //this specification needs my search string.
        SearchSpecification<AccountRight> rightByAppointmentID = 
                  new SearchSpecification<AccountRight>(new SearchCriteria("rightByAppointment.appointmentID", SearchOperation.EQUALITY, CommonUtil.getAppointment().getAppointmentID())); //this specification accepts search criteria with key, operation and value.


        Page<AccountRight> accountRightPage = accountRightRepository.findAll(Specification.where(rightByAppointmentID).and(searchSpec), pageable); 

//here you will just tell findAll method to findAll entities where rightByAppointmentID is equal to
   //CommonUtil.getAppointment().getAppointmentID() and search query is searchSpec