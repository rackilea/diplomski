Result[] individarrayresult = new Result[resultlist.size()];

for (int i = 0; i < resultlist.size(); i++) {
    Result res = resultlist.get(i);
    if (res.athleteStartNumber() == DSN) {
        individarrayresult[i] = res;
    }
}