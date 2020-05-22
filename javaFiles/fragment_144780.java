public static void Schrittzähler (long Startwert, long Schrittweite, long Endwert) {

        for(long i = Startwert; i <= Endwert; i = i + Schrittweite) {
                    System.out.println(i + ",");
        }

    }