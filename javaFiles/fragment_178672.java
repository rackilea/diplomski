@Entity
public class Staff {
  ...
  @OneToOne
  @JoinColumn(name = "boss_id")
  Person boss;

  @OneToOne
  @JoinColumn(name = "employee_id")
  Person employee;
  ...
}