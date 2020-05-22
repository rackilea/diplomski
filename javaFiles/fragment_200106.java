import java.util.Arrays;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import de.odysseus.el.util.SimpleContext;

public class Sof9404739 {
  /**
   * Sample item
   */
  public static class MyItem {
    String name;
    public MyItem(String name) {
      this.name = name;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
  }

  /**
   * Sample model
   */
  public static class MyModel {
    List<MyModel> list;
    public List<?> getList() {
      return list;
    }
    public void setList(List<MyModel> list) {
      this.list = list;
    }
  }

  /**
   * EL expression factory
   */
  static ExpressionFactory factory = ExpressionFactory.newInstance();

  public static void main(String[] args) {
    /**
     * Simple EL context implementation from JUEL
     */
    ELContext context = new SimpleContext();

    /**
     * Define the two expressions
     */
    ValueExpression listExpr =
      factory.createValueExpression(context, "#{model.list}", List.class);
    ValueExpression nameExpr =
      factory.createValueExpression(context, "#{item.name}", String.class);

    /**
     * This looks like a variable, but it isn't - it's a "root property"
     */
    context.getELResolver().setValue(context, null, "model", new MyModel());

    /**
     * Just for fun, initialize model's list property via EL, too
     */
    context.getELResolver().setValue(context, "model", "list",
        Arrays.asList(new MyItem("alice"), new MyItem("bob")));

    /**
     * Evaluate expressions like c:forEach
     */
    for (Object item : (List<?>) listExpr.getValue(context)) {
      /**
       * For each item, define the "item" (root) property
       */
      context.getELResolver().setValue(context, null, "item", item);
      System.out.println(nameExpr.getValue(context)); // "alice", "bob"
    }
  }
}