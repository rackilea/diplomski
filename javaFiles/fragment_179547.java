if (input.equals("search")) {

        System.out.println("Enter a name");
        name = in.readLine();

        System.out.println("Enter a id guideline");
        input = in.readLine();

        String parts[] = input.split("-");

        int lower = 0;
        int upper = 0;

        if (parts.length >= 1 && parts.length <= 2) {
            if (parts.length == 2) {
                if (parts[0] != null && parts[0].trim().length() > 0) {
                    // x-x
                    lower = Integer.parseInt(parts[0]);
                    upper = Integer.parseInt(parts[1]);
                } else {
                    // -x
                    lower = Integer.MIN_VALUE;
                    upper = Integer.parseInt(parts[1]);
                }
            } else if (parts.length == 1) {
                // x-
                lower = Integer.parseInt(parts[0]);
                upper = Integer.MAX_VALUE;
            }
            for (Store store : stores) {
                if (store.id >= lower && store.id <= upper && store.name.equals(name)) {
                    System.out.println(store);
                }
            }
        } else {
            System.out.println("Invalid input");
        }

    }
}