List<Object> objList = dao.getStatus();
        List<DbMetaPojo> metaList = new ArrayList<DbMetaPojo> ();
        if (objList != null && objList.size() > 10000) {
            for (Object nameObj : objList) {
                DbMetaPojo meta = new DbMetaPojo();
                meta.setRecordID(nameObj[0]);
                meta.setRecordName(nameObj[0]);
                ...
                ...
                ...

                metaList.add(meta);
            }
        }