public void startGame(String key){
                i = new Intent(OnlineGame.this, Start.class);
                i.putExtra("key", ""+key);
                i.putExtra("hostState", ""+hostState);
                startActivity(i);
            }