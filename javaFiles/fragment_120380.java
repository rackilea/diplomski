int n = 0;
    while (rs.next()) {

        int n2 = rs.getInt(1);

        if (!(n == 1)) {
            return availableId;
        } else if (!(n2-- == n)) {
            availableId = n++;
        }

        n = n2;
    }