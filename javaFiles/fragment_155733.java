Query query = session.createQuery(
          "select p.projectId, "
        + "p.projectName, "
        + "(select sum(i.incomeAmount) from Income i where i.incomeProject = p), "
        + "(select sum(e.expenseAmount) from Expense e where e.expenseProject = p), "
        + "from Project as p"
                  + "group by p.projectId, pi.investorId ")
        .setFirstResult(firstResult)
        .setMaxResults(maxResult);