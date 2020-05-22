public class Wrapper{
    private List<Paciente> pacientes = new ArrayList<>();

    public void addPaciente(Paciente paciente){
        if(!this.pacientes.contains(paciente)) // prevent multi entries
            paciente.add(paciente);
    }

    public void addPacientes(List<Paciente> pacientes){
        for(Paciente paciente : pacientes) // add all patients using the add method
            this.addPaciente(paciente);
    }

    public List<Paciente> getPacientes(){
        return this.pacientes;
    }
}