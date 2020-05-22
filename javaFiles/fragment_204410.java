List<> individResults = new Arraylist<Result>(resultlist.size());

for (int i = 0; i < resultlist.size(); i++) {
    Result res = resultlist.get(i);
    if (res.athleteStartNumber() == DSN) {
        individResults.add(res);
    }
}