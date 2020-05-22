public static void main(String[] args) {
        List<String[]> datas = new ArrayList<String[]>();
        datas.add("John,Car,4324,4944".split(","));
        datas.add("Jill & Peter,Bus,5433,6544".split(","));
        datas.add("Greg,Bus,9384,4329".split(","));
        datas.add("Jill & Greg and Bill,Truck,3213,4324".split(","));
        datas.add("Mike,Bus,4324,3424".split(","));
        datas.add("Greg & Lisa & John,bus,4324,4334".split(","));
        datas.add("Greg & roland & John,bus,4324,4334".split(","));

        for (String[] data : datas) {
            if(data[0].contains("&") || data[0].contains(" and ")) {
                String[] names = data[0].split("&|(\\sand\\s)");
                for (String name : names) {
                    data[0] = name.trim();
                    System.out.println(Arrays.toString(data));
                }
            }else {
                System.out.println(Arrays.toString(data));
            }
        }
    }