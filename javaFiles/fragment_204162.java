class Sample {
    private final ImmutableMap<Long, AtomicReference<Stuff>> container;

    Sample(){
        this.container = getMap();
    }

    void setStuff(Long id, Stuff stuff){
        AtomicReference<Stuff> holder = container.get(id);
        holder.set(stuff);
    }
}