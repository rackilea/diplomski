@Transient
public List<Long> getHorarios(){
    List<Long> horarios = new ArrayList<Long>();

    for(Long i = horarioInicio; i <= horarioFin; i+=300){
        horarios.add(i);
    }
    return horarios;

}

@Transient
public List<Long> getHorariosLibres(List<Long> horariosTomados){

    List<Long> horariosLibres = getHorarios();
    horariosLibres.removeAll(horariosTomados);

    return horariosLibres;

}