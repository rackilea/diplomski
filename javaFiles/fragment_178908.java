//skip null records in database
            if (objectDate.length() < 10) {
                continue;
            } else {
                recordDateAsString = objectDate.substring(0, 10);
            }