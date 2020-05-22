UpgradesButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                     Intent intent = new Intent(MainActivity.this, UpgradesActivity.class);
                    intent.putExtra("key_int", balance);
                    startActivity(intent);
                }
            });