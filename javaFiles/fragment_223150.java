StringBuilder stringBuilder = new StringBuilder();
    for (T o : records) {

        int numberOfFields = o.getClass().getDeclaredFields().length;
        int counter = 1;

        Field[] f = o.getClass().getDeclaredFields();
        for (int i = 0; i < o.getClass().getDeclaredFields().length; i++) {
            f[i].setAccessible(true);
            Object value = null;
            try {
                value = f[i].get(o);

                if (counter < numberOfFields) {
                    stringBuilder.append("\"").append(value).append("\"").append(",");
                } else {
                    stringBuilder.append("\"").append(value).append("\"").append(System.getProperty("line.separator"));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            counter++;
        }


    }