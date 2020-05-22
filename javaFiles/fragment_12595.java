public class MealListener implements Listener {

  @Override
  public boolean process(Event event) {
    if (event instanceof Breakfast) {
       this.onBreakfast((Breakfast) event);
       return true;
    }
    if (event instanceof Dinner) {
       this.onDinner((Dinner) event);
       return true;
    }
    return false; // MealListener ignores this event
  }

  private void onBreakfast(Breakfast breakfastCall) {
    // eat breakfast
  }

  private void onDinner(Dinner dinnerCall) {
    // eat dinner
  }

}