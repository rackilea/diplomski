package model;

public class EndRace {
      private ObservableList<String> rankList = FXCollections.observableArrayList();

      public ObservableList<String> getRankList() {
           return rankList;
      }
 } 

package gui;
...
ListView<String> currentRank = new ListView(endRace.getRankList()));