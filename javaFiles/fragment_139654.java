for (int i = 0; i < poiListPojo.size(); i++) {
            if (poiListPojo.get(i).getStatus().equals("ACTIVE")) {
                Toast.makeText(MainActivity.this, poiListPojo.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                }
        }
    }