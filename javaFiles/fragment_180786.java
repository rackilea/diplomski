List<Employee> filteredList = new ArrayList<>();
    for(Employee e : allEmployeesOfCompany) {
        if(!e.parkingSpace)
            filteredList.add(e);
    }

    Collections.sort(filteredList, new YearsComp());