@OneToMany(mappedBy = "barn", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
private List<Horse> horses = new ArrayList<>();

public void addHorse(Horse horse) {
    this.horses.add(horse);
    horse.setBarn(this);
}