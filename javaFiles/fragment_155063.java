public static void main(String[] args) {

        Workshift[] workshifts = new Workshift[10];
        for (int i = 0; i < workshifts.length; i++) {
            //Replace Context(i) for the real one
            workshifts[i] = new Workshift(new Context(i), "Workshift#"
                    + i);
        }
        System.out.println("Original Workshifts array:");
        for (int i = 0; i < workshifts.length; i++) {
            System.out.println(workshifts[i]);
        }
        System.out.println("===================================");

        GsonBuilder gsonBuilder = new GsonBuilder();
        new GraphAdapterBuilder()
        .addType(Visit.class)
        .addType(Workshift.class)
        .registerOn(gsonBuilder);

        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String serialized = gson.toJson(workshifts);
        // System.out.println(serialized);
        Workshift[] w_array = gson.fromJson(serialized, Workshift[].class);
        // System.out.println(gson.toJson(w_array));

        System.out.println("Des-serialized Workshifts array:");
        for (int i = 0; i < w_array.length; i++) {
            System.out.println(w_array[i]);
        }
        System.out.println("===================================");