Comparator<Region> compassComporator = (r1, r2) -> {
    //this assumes both objects (and their m_region field) are not null, else do a check for null

    if (r1.m_region.equals(r2.m_region)) {
        return 0;
    }
    if ("West".equals(r1.m_region)) {
        return 1;
    }
    if ("West".equals(r2.m_region)) {
        return -1;
    }
    if ("Midwest".equals(r1.m_region)) {
        return 1;
    }
    if ("Midwest".equals(r2.m_region)) {
        return -1;
    }
    if ("Southeast".equals(r1.m_region)) {
        return 1;
    }
    if ("Southeast".equals(r2.m_region)) {
        return -1;
    }
    if ("Southwest".equals(r1.m_region)) {
        return 1;
    }
    if ("Southwest".equals(r2.m_region)) {
        return -1;
    }
    if ("Northeast".equals(r1.m_region)) {
        return 1;
    }
//        if ("Northeast".equals(r2.m_region)) {
    return -1;
//        }

};

public class PaintRegion extends JPanel {       
    public ArrayList<Region> m_region = new ArrayList<Region>(); 
    // some codes
    m_region.sort(compassComporator);
}