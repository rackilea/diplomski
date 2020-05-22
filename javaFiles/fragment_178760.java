public List getAllEmployeesByEmpStatus (String status) { 
try { 
    return employeePersistence.findByEmpStatus(status); 
} catch (SystemException e) {
    e.printStackTrace(); return Collections.emptyList(); 
    }
}