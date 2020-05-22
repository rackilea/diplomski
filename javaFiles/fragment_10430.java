Intent intent = new Intent(getApplicationContext(),
                            MainActivity.class);

                    //Data
                    intent.putExtra("muscle", muscle);
                    intent.putExtra("exercise", exercise);
                    intent.putExtra("frag", 1);

                    startActivity(intent);