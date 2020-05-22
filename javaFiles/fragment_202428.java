companySiteList.stream()
               .filter(companySite -> companySite.getId().equals("ID"))
               .flatMap(obj -> obj.getEmployeeList
                                  .stream()
                                  .filter(employee -> employee.getId().equals("ID_EMPLOYEE"))
                                  .map(emp -> new AbstractMap.SimpleEntry<Company,Employee>(obj,emp)))
               .forEach(entry -> orderFurniture (entry.getKey(),entry.getValue()));