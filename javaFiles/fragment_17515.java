/*This method is subject of a known bug: https://bugs.openjdk.java.net/browse/JDK-8179097, this bug is
     * already in list to be fixed in a later version of openjfx */
//  private void refresh_opt() {
//      if (this.opt == true) {
//          map_menu.setDisable(false);
//          map_menu.setVisible(true);
//      } else {
//          map_menu.setDisable(true);
//          map_menu.setVisible(false);
//      }
//  }

    private void refresh_opt() {
        if (this.opt == true) {
            map_menu.setDisable(false);
        } else {
            map_menu.setDisable(true);
        }
    }