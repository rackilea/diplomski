Employee newEmployee = new Employee("matt");
vehicle1.setAssociatedEmployee(newEmployee);
vehicles.add(vehicle1);

newEmployee.setVehicles(vehicles);

Employee savedEmployee = employeeDao.persistOrMerge(newEmployee);