PreparedStatement ps9 = con.prepareStatement("UPDATE payroll_system.payslip 
     SET expense_claims = (SELECT SUM(Expense) 
     FROM payroll_system.expense_master 
     WHERE employeeID=?) WHERE employeeID=?");

     ps9.setString(1, employee_id);
     ps9.setString(2, employee_id);
     ps9.executeUpdate();