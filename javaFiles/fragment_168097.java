try {
        Field idField = R.String.class.getDeclaredField(getHeaderStringID());
        int value = idField.getInt(idField);
    } catch (Exception e) {
        e.printStackTrace();
        return -1;
    }