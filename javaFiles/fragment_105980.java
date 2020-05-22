String previousBeam = null;
    while (rs.next()) {
        String currentBeam = rs.getString(2);
        if (!currentBeam.equals(previousBeam)) {
            previousBeam = currentBeam;
            Comaprision ref = new Comaprision();
            ref.setLogtime(rs.getString(1));
            // ...
            ref.setSt2_vs2_bag9_rb(rs.getString(12));
            stJsp.add(ref);
        }
    }