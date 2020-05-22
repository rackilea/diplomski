String taskHqlString = "select Task "  
                     + "  from Task join Task.Officer o "
                     + "            join o.Company c "
                     + " where c.name = :companyKey";

List<Task> list = (List<Task>)hibernateSession
                  .createQuery(taskHqlString)
                  .setParameter("companyKey", companyKeyValue)
                  .list();