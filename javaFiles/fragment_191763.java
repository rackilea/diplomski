WebDriverWait wait = new WebDriverWait(Drivers.getDriver(), 10);
wait.until(ExpectedConditions.visibilityOf(countdownLabel));

String players_in_game = "0";
if(num_of_players_in_game.isDisplayed()){
   players_in_game = num_of_players_in_game.getText();   
}

System.out.println(players_in_game);
int first_num = Integer.parseInt(players_in_game);