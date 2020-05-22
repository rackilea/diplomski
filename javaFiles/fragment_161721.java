List<Paciente> pacientes = new ArrayList<>(); // no size constraints, automatically expands if too small

pacientes.add(new Paciente("", "", ""));

for (Paciente paciente : pacientes) { // loop all Patientes in pacientes
    kSession.insert(paciente); // add a paciente to the session, for every entry
}