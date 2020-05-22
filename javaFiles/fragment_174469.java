public class TestMain {

  public enum Choice {
    A, B, C
  }

  public static void main(String[] args) {
    selectItem(0);
  }

  public static void selectItem(int position) {
    Choice selectedChoice = null;
    selectedChoice = getChoiceFromPosition(position, selectedChoice);

    switch (selectedChoice) {
      //Dashboard
      case A:
        System.out.println(selectedChoice.ordinal());
        break;
      case B:
        break;
      case C:
        break;
    }
  }

  private static Choice getChoiceFromPosition(int position, Choice selectedChoice) {
    for(Choice c : Choice.values()){
      if(c.ordinal() == position) {
        selectedChoice =c;
      }
    }
    return selectedChoice;
  }
}