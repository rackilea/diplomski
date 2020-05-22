if(employee.manager != null){
                // we retrieve the manager from the map and add this employee in the list inside it
                Employee manager = employees.get(employee.manager);
                if(manager != null){
                    // manager has been loaded before
                    manager.add(employee);
                }
            }