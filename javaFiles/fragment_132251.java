class Configuracao {

    private String departamento;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public String getDepartamentos() {
        return departamento + " " + ThreadLocalRandom.current().nextDouble();
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "departamento='" + departamento + '\'' +
                '}';
    }
}