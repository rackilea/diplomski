yourButton.setOnClickListener(v -> {
            if (count == 0) { // the first click
                count++;
                // do your stuff

            }else { // the second click
                count = 0; // initialize the count to limit the button click just for the first and the second time only
                // do your stuff
            }

        });