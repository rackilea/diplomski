public int compare(Object o1, Object o2) {
                PlayerStats p1 = (PlayerStats) o1;
                PlayerStats p2 = (PlayerStats) o2;
                int res =  p1.getPlayerLastName().compareToIgnoreCase(p2.getPlayerLastName());
                if (res != 0)
                    return res;
                return p1.getPlayerFirstName().compareToIgnoreCase(p2.getPlayerFirstName())
            }