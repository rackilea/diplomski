companySiteList.stream()
               .filter(companySite -> companySite.getId().equals("ID"))
               .flatMap(obj -> obj.getEmployeeList
                                  .stream()
                                  .filter(employee -> employee.getId().equals("ID_EMPLOYEE")))
               .forEach(emp -> orderFurniture ("ID","ID_EMPLOYEE"));