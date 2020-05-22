Iterator<SimEvent> fit = future.iterator();
while (fit.hasNext()) {
    SimEvent event = fit.next();
    processEvent(event);
    fit.remove();
}