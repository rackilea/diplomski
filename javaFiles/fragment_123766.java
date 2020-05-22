List usersList = new ArrayList();
List compList = new ArrayList();

do
{
  yourChoice = GetValidUserInput(promptString);
  usersList.add(yourChoice);

  randomNum = (int) (Math.random() * 3);
  computerChoice = GenerateComputerChoice(randomNum);
  compList.add(computerChoice);

  TheVictor(yourChoice, computerChoice);
  decide = JOptionPane.showInputDialog("Would you like to play another game?");
}while(!decide.equals("no") || decide.equals("yes"));

String[] user = (String[])usersList.toArray(new String[usersList.size()]);
String[] computer = (String[])compList.toArray(new String[compList.size()]);
if(decide.equals("no"))
{
   Results(user, computer);
}