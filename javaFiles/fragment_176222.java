public void Clustering( ODData[] routes )
{
    Vector<ODData> routesVector = new Vector<ODData>();
    for (ODDatas s : routes) {
        routesVector.add(s);
    }
    myData.add(routesVector);     
}