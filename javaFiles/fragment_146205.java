// So that spring can inject the business singleton
protected EventoService serviceEvento;

public void setServiceEvento(EventoService value) {
    serviceEvento=value;
}