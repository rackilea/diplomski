Integer empMetaData = 
                (Integer) session.createCriteria(EmployeeTopMetaData.class) // This is the line #50
                .setProjection(Projections.property("valueEmpId"))
                .add(Restrictions.eq("testingId", 1234))
                .add(Restrictions.eq("company_employee_id", 3345))
                .uniqueResult();