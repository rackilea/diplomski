enum DepartmentName {
     FINANCE        ("FIN", "Finance")
   , SALES          ("SAL", "Sales")
   , PAYROLL        ("PYR", "Payroll")
   , LOGISTIC       ("LGT", "Logistic")
   ;

    private final String department;
    private final String description;

    DepartmentName(String abbr, String full) {
        department = abbr;
        description = full;
    }

    public String getDepartmentCode() {return department;}

    public String getDescription() {return description;}

    @Override
    public String toString() {
        return "The department name is " + getDepartmentCode();
    }
}