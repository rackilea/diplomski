class JsonCollection {

    ArrayList<Hisab> employees;

    public JsonCollectio() {
        this.employees = new ArrayList<Hisab>();
    }

    public void setEmployees( ArrayList<Hisab> emps ) {
        this.employees = emps;
    }

    public ArrayList<Hisab> getEmployees() {
         return this.employees;
    }

    public void addHisab( Hisab h ) {
         this.employees.add( h );
    } 

}