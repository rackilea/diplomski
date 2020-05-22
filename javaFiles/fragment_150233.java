@Entity
public class Leader extends Person implements Serializable {

    @OneToMany(mappedBy = "leader")
    private List <Person> listTeam;
    //getter and setter

    public void addPersonInTeam(Person e) {
        listTeam.add(e);
    }
}