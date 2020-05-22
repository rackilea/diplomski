@Entity
    public class Trainer {
        @OneToMany
        @JoinTable(
            name="TrainedMonkeys",
            joinColumns = @JoinColumn( name="trainer_id"),
            inverseJoinColumns = @JoinColumn( name="monkey_id")
        )
        public Set<Monkey> getTrainedMonkeys() {
        ...
    }