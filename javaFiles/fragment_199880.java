String getcontent = "";
        try {
            getcontent = cursor.getString(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }