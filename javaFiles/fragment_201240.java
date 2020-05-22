String query = "SELECT 'TABLE_A', " + A + ", " + B+ ", " + C
            + " FROM " + TABLE_A+ " UNION ALL SELECT 'TABLE_B' " + A+ ", "
            + B+ ", " + C+ " FROM " + TABLE_B 
            + " UNION ALL SELECT 'TABLE_C', " + A+ ", " + B+ ", "
            + C+ " FROM " + TABLE_C + " UNION ALL SELECT 'TABLE_D', "
            + A+ ", " + B+ ", " + C+ " FROM "
            + TABLE_D;