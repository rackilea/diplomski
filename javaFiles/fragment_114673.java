for(Entity entity : entities) {
        if(accountsByReport.containsKey(entity.getReportID())) {
            ((List<String>)accountsByReport.get(entity.getReportID())).add(entity.getDepAccount());
        } else {
            List<String> list = new ArrayList<String>();
            list.add(entity.getDepAccount());
            accountsByReport.put(entity.getReportID(), list);
        }
    }