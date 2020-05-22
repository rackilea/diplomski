for (int i = 0; i < nodes; i++) {
        s = f.readLine();
        String z [] = s.split(" ");
        String start = z[0];

        // Declare the variables here, otherwise code is the same
        int c = -1;
        int c1 = 2;
        int c2 = 3;

        for (int j = 0; j < z.length; j++) {
            int t = c+c1;
            int t2 = c+c2;

            if (t >= z.length) {
                break;
            }
            String des = z[t];

            if (t2 >= z.length+1) {
                break;
            }
            String weight = z[t2];

            L.add(start + " " + des + " " + weight);

            c1+=2;
            c2+=2;
        }
    }