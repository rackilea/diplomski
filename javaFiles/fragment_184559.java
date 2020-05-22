@Embeddable
public class PizzaIngredientPk {
    private MySQLPizzaHibernateEntity pizza;
    private MySQLIngredientWithAmountHibernateEntity ingredient;

    @ManyToOne
    public MySQLPizzaHibernateEntity getPizza() {
        return pizza;
    }
    public void setPizza(MySQLPizzaHibernateEntity pizza) {
        this.pizza = pizza;
    }

    @ManyToOne
    public MySQLIngredientWithAmountHibernateEntity getIngredient() {
        return ingredient;
    }
    public void setIngredientID(MySQLIngredientWithAmountHibernateEntity ingredient) {
        this.ingredient = ingredient;
    }
}