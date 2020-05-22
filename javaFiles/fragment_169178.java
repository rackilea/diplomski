String plsql = 
    "DECLARE" +
    "  l_curs   SYS_REFCURSOR; " +
    "BEGIN" +
    "  OPEN l_curs FOR" +
    "     SELECT e.department_id , e.last_name ," +
    "            e.salary FROM employees e , (SELECT department_id ," +
    "            MAX(salary) AS maxSal FROM employees GROUP BY department_id)" +
    "            m WHERE e.department_id = m.department_id" + 
    "            AND e.salary = m.maxSal ORDER BY e.salary;" +
    "" +            
    "  HR.EMP_PKG.print_max_sal_all_dept(l_curs, ?);" +
    "END;"

PreparedStatement stmt = conn.prepareStatement(plsql);
stmt.registerOutParameter(1, java.sql.Types.NUMERIC);
stmt.execute();