ArrayList<String> Teams = new ArrayList<>();

private void addTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
String Team = addTeamText.getText(); 
System.out.println (Team);
Teams.add(Team);
addTeamText.setText("");