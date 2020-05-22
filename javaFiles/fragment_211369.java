public void setLevel(Level newLevel) {
     if (!Objects.equals(levels, newLevel)) {
         if (levels != null) {
              // cleanup old level
              levels.updateGameLevelEnd(this);
         }
         levels = newLevel;
         if (newLevel != null) {
              // start new level
              newLevel.updateGameLevelStart(this);
         }
     }
}