String first_name ="",last_name="";
 String fullname = account.getDisplayName();
            try {
                if (fullname != null) {
                    if (!fullname.equalsIgnoreCase("")) {
                        String[] name_array = fullname.split(" ");
                        if (name_array.length > 0) {
                            first_name = name_array[0];
                            last_name = name_array[1];
                        }

                    }
                } else {
                    // do stuff
                }

            } catch (Exception e) {
                e.printStackTrace();
            }