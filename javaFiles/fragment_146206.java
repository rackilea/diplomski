// So that spring can inject the business singleton
protected EventoService eventoService;

public void setEventoService(EventoService value) {
    eventoService=value;
}