private int getMarkerIcon(String type) {
        int id = 0;
        if(type == null) {
            return R.drawable.ic_restaurant_map;
        }

        switch (type) {
            case "cafe" :
                id = R.drawable.ic_cafe_map;
                break;

            case "department _ stores" :
                id = R.drawable.ic_department_store;
                break;

            case "restaurant" :
                id = R.drawable.ic_restaurant_map;
                break;

            case "bar" :
                id = R.drawable.ic_bar_map;
                break;

        }
        return id;
    }