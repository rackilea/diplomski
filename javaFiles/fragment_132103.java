if (count == 4) {
        boolean updated = false; //TODO remove when happy
        int old_points = my_db.getPoints(Username); //TODO remove when happy
        if (my_db.increasePoints(Username,countPoints) > 0) {
            updated = true;
        }
        int new_points = my_db.getPoints(Username); //TODO remove when happy

        //TODO remove following code when happy
        String result = "The result of the attempt to update the points for user " + Username;
        if (updated) {
            result = result + " was successful. ";
        } else {
            result = result + " was unsuccessful.";
        }
        Log.d("POINTSINCREASE",result +
                " Points were " + String.valueOf(old_points) + " points are now " + String.valueOf(new_points));
    }