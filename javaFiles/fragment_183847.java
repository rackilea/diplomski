String opt_1 = opt1.getText().toString();
    if (opt_1.equals(correctans)) {
                opt1.setTextColor(getResources().getColor(R.color.correct_ans));
                iv_optA.setImageResource(R.drawable.correctans);
            } else {
                opt1.setTextColor(getResources().getColor(R.color.wrong_ans));
                iv_optA.setImageResource(R.drawable.wrongans);
                if (opt_1.equals(correctans))
                    opt1.setTextColor(Color.BLUE);
                if (opt_2.equals(correctans))
                    opt2.setTextColor(Color.BLUE);
                if (opt_3.equals(correctans))
                    opt3.setTextColor(Color.BLUE);
                if (opt_4.equals(correctans))
                    opt4.setTextColor(Color.BLUE);
            }