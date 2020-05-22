class Racer {
    private String name;
    private int stamina;
    ...
    public Racer(String name) {
       this.stamina = Math.random(...);
       ...
    }

    public function getStamina() {
       return this.stamina;
    }
}