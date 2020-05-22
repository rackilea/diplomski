Intent sendIntentToMainActivity = new Intent(PlayersActivity.this, MainActivity.class);
            Bundle bundle1 = new Bundle();

            bundle1.putString("name", name);
            bundle1.putInt("buttonId", buttonId);


            sendIntentToMainActivity.putExtra("bundle",bundle1);
            startActivity(sendIntentToMainActivity);