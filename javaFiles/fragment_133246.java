for(Family family : fosterHome.getFamilies()) {
        System.out.println(family.getParentID());
        for(String childID : family.getChildList()) {
            System.out.println("    " + childID);
        }
    }