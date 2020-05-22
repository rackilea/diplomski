public class SelectLoanChoices {
 public static void main(final String[] args) {
  final String[] choices = { "7 years at 5.35%", "15 years at 5.5%", "30 years at 5.75%" };
  final Object choice = JOptionPane.showInputDialog(null, "Select a Loan", "Mortgage Options",
    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
  System.out.println(getChoiceIndex(choice, choices));

 }

 public static int getChoiceIndex(final Object choice, final Object[] choices) {
  if (choice != null) {
   for (int i = 0; i < choices.length; i++) {
    if (choice.equals(choices[i])) {
     return i;
    }
   }
  }
  return -1;
 }
}