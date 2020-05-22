class Principal {
    ArrayList<Empleado> arrEmpleados = new ArrayList<Empleado>(); 

    public void addAEmpleado(){
        arrEmpleados.add(new Empleado(541000, 2400.0, 40.0, 16, 20.0, 2));
    }
}