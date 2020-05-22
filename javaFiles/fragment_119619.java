for (Field field : ModelMarketBanners.class.getDeclaredFields()) {
        for (Method method : ModelMarketBanners.class.getMethods()) {
            if ((method.getName().startsWith("get")) && (method.getName().length() == (field.getName().length() + 3))) {
                if (method.getName().toLowerCase().endsWith(field.getName().toLowerCase())) {
                    try {
                        Object value = method.invoke(model);
                        if (!TextUtils.isEmpty(String.valueOf(value)) {
                            Log.v("data is: ", String.valueOf(value));
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                    }

                }
            }
        }
    }