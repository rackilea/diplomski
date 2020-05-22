for(SomeVO some:myList) {
            if(some.getAuditType().equalsIgnoreCase("AuditX")) {
                auditX.add(some);
            } else {
                auditY.add(some);
            }
        }
        Collections.sort(auditX, new AuditComparator());            
        Collections.sort(auditY, new AuditComparator());

    public class AuditComparator implements Comparator<SomeVO> {

            @Override
            public int compare(SomeVO o1, SomeVO o2) {
                int value1 = o2.getUsageCount().compareTo(o1.getUsageCount());
                 if (value1 == 0) {
                        int value2 = o1.getNumberofReturns().compareTo(o2.getNumberofReturns());
                        if (value2 == 0) {
                            return (o1.getTrendType().equalsIgnoreCase("Trend") && o2.getTrendType().equalsIgnoreCase("Trend")) ?
                                    o1.getTrendNumber().compareTo(o2.getTrendNumber()):o1.getNonTrendNumber().compareTo(o2.getNonTrendNumber());
                        } else {
                            return value2;
                        }            
            }
                return value1;
        }