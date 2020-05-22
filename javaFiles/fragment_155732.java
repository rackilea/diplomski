public class Project {
    ...

    @OneToMany
    List<Expense> expenses;

    @OneToMany
    List<Income> incomes;

    ...
}