case R.id.btnCalcCalories:
            double weight = Integer.parseInt(etWeight.getText().toString());
            double bodyfat = Integer.parseInt(etBodyfat.getText().toString());
            ;
            lbm = weight * (100 - bodyfat) / 100;
            bmr = 370 + (21.6 * lbm);
            maintCals = bmr * actLevel;

            maintCalories.setText("Calories need to maintain current bodyweight: " + String.valueOf(maintCals));

            lbmResult.setText("Your Lean Body Mass is " + String.valueOf(lbm)
                    + "Kg");
            bmrResult.setText("Your Base Metabolic rate is "
                    + String.valueOf(bmr) + " calories");
            calorieResult.setText("Your Daily calorie goal is " + String.valueOf(finalGPercentage) + " calories");
            break;