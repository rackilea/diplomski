for (Games  game : Games.values()) {
                TableRow newRow = new TableRow(this);
                newRow.setLayoutParams(tableRowParams);

TableRow.LayoutParams params2 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT);

                params2.weight = .8f;
                params2.gravity= Gravity.CENTER;

                String[] words = game.name().split("(?=[A-Z])");
                String name = "";
                for (String word : words) {
                    if(word.length() < 1) continue;
                    name += word + "\n";
                }

                tv = new TextView(this);
                tv.setTextSize(fontSize);
                tv.setText(name);
                tv.setLayoutParams(params2);
                newRow.addView(tv);
                newRow.setWeightSum(6);

                for (Level level : Level.values()) {
                    ImageView iv = new ImageView(this);

                    iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    iv.setAdjustViewBounds(true);
                    iv.setLayoutParams(params);

                    tv = new TextView(this);
                    tv.setLayoutParams(params);
                    tv.setText("EASY");
                    tv.setTextSize(fontSize);

                    if( acheivements.getPassed(level, game) )//has achievement
                    {
                        iv.setImageResource(R.drawable.star_gold_full_small);
                    }
                    else {
                        iv.setImageResource(R.drawable.star_gold_empty_small);
                    }
                    newRow.addView(tv);
                }
                tbLayout.addView(newRow);
            }