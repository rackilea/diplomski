JSONArray covabbrv = new JSONArray();
JSONArray dcIssuedt = new JSONArray();
JSONArray vecatg = new JSONArray();
Iterator<String> x = dlcov.keys();
    while (x.hasNext()){
        String key1 = x.next();
        String value1 = dlcov.optString(key1);
        covabbrv.put(key1);
        dcIssuedt.put(value1);
        vecatg.put(key1);
    }
dlCovs.put("covabbrv",covabbrv);
dlCovs.put("dcIssuedt",dcIssuedt);
dlCovs.put("vecatg",vecatg);