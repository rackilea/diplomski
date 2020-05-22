Employee objEmployee = (Employee) session.get(Employee.class, 1);
Address objAdd = new Address();
objAdd.setId(200);
objAdd.setCity("Mumbai");
objAdd.setState("Maharashtra");
objAdd.setObjEmployee(objEmployee);
//objEmployee.getLstAddress().add(objAdd);
// save objAdd not objEmployee
session.saveOrUpdate(objAdd);