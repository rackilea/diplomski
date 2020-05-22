@Entity
    @Table(name = "horario")
    public class Horario implements Serializable {

        private static final long serialVersionUID = 1L;
        private Long id;
        private Integer dia;
        private Integer horarioInicio;
        private Integer horarioFin;
        private Integer duration;

        @Id
        @GeneratedValue
        @Column(name = "id")
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Column(name = "dia")
        public Integer getDia() {
            return dia;
        }

        public void setDia(Integer dia) {
            this.dia = dia;
        }

        @Column(name = "horario_inicio")
        public Integer getHorarioInicio() {
            return horarioInicio;
        }

        public void setHorarioInicio(Integer horarioInicio) {
            this.horarioInicio = horarioInicio;
        }

        @Column(name = "horario_fin")
        public Integer getHorarioFin() {
            return horarioFin;
        }

        public void setHorarioFin(Integer horarioFin) {
            this.horarioFin = horarioFin;
        }

        @Transient
        public List<Integer> getHorarios(){
            List<Integer> horarios = new ArrayList<Integer>();
            for(Integer i = horarioInicio; i <= horarioFin; i+=duration){
                horarios.add(i);
            }
            return horarios;
        }

        @Column(name = "duration")
        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        @Transient
        public List<String> getHorariosLibres(List<Integer> horariosTomados){

            List<Integer> horariosTemporal = getHorarios();
            horariosTemporal.removeAll(horariosTomados);
            List<String> horariosLibres = new ArrayList<String>();
            for (Integer horario : horariosTemporal){
                int hours = (horario / 60);
                int minutes = (horario % 60);
            String hours1 = null;
            String minutes1 = null;
                if(hours == 7 || hours == 8 || hours == 9){
                    hours1 = "0" + hours + ":";
                }else{
                    hours1 = hours + ":";
                }
                if(minutes == 5 || minutes == 0){
                    minutes1 = "0" + minutes;
                }else{
                    minutes1 = String.valueOf(minutes);
                }

                horariosLibres.add(hours1 + minutes1);

            }

            return horariosLibres;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Horario other = (Horario) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

    }