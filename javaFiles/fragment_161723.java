public class Paciente{
    private List<Sintomas> sintomas = new ArrayList<>();

    public addSintomas(Sintomas sintomas){
        if(!this.sintomas.contains(sintomas))
            this.sintomas.add(sintomas);
    }
    // rest is the same principle as above in "Wrapper"
}