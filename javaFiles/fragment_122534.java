items.forEach(item -> {
        try {
            getData(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });