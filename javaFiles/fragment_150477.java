@Override
      public void onBackPressed() {
        isBackPressed = true;
        if (tabsInBack != null && tabsInBack.size() > 0) {
          if (tabs.getSelectedTabPosition() == tabsInBack.get(tabsInBack.size() - 1)) {
            tabsInBack.remove(tabsInBack.size() - 1);

          }
          if (tabsInBack != null && tabsInBack.size() > 0) {
            tabs.getTabAt(tabsInBack.get(tabsInBack.size() - 1)).select();
            tabsInBack.remove(tabsInBack.size() - 1);

          } else {
            super.onBackPressed();
          }
        } else {
          super.onBackPressed();
        }
      }