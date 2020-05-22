public String id_data(ArrayList<Integer> data) {
        StringBuilder val = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            val.append(String.valueOf(data.get(i)));
            if (i < data.size() - 1) {
                val.append(",");
            }
        }
        return val.toString();
    }