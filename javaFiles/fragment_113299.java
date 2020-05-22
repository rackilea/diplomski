CREATE OR REPLACE FUNCTION getEmpArray RETURN EMPARRAY
AS
  l_data EmpArray := EmpArray();
  CURSOR c_emp IS SELECT ename FROM EMP;
  BEGIN
    FOR emp_rec IN c_emp LOOP
      l_data.extend;
      l_data(l_data.count) := emp_rec.ename;
    END LOOP;
    RETURN l_data;
  END;