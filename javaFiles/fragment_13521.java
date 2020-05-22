public enum GameState {
    TITLE_STATE = 0,
    MAINGAME_STATE,
    PAUSE_STATE,
}

void GameStateUpdate() {
     // handle update
    switch(m_curState) {
       case TITLE_STATE:
          UpdateTitleScreen();
          if(UserPressesEnter()) {
              m_curState = MAINGAME_STATE;
          }
          break;
       case MAINGAME_STATE:
          UpdateMainGame();
          if(UserPressesPause()) {
              m_curState = PAUSE_STATE;
          }
          break;
       case PAUSE_STATE:
          UpdatePause();
          if(UserDoneWithPause()) {
              m_curState = MAINGAME_STATE;
          }
          break;
    }
}