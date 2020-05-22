@Entity
    public class Meal {

@Id
@GeneratedValue
  private Long id;

  @OneToOne
  @JoinColumn(name = "meel_cook_id")
  private Student mealCook;

  private String mealName;

  private int mealPrice;