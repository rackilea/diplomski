runOnUiThread(new Runnable() {
                Player player;
                RelativeLayout mainScreen = (RelativeLayout)findViewById(R.id.relativeLayout);
                @Override
                public void run() {
                    player = new Player(savedData.getString("name" + playerNum, null), savedData.getInt("score" + playerNum, 0), playerNum, savedData.getBoolean("enabled" + playerNum, false), mainScreen, presetButtonList, editor, mainActivity);    
                    playerList.add(player);
                    player.updateScreen();
                    mainScreen.invalidate();
                }
            });