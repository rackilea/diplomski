public static void main (String[] args)
{
    /* Sample Space */
    String[] strArr = new String[] {
        "February_Report_files\\customerst.rptdesign",
        "February_Report_files\\Top10Percent.rptdesign",
        "February_Report_files\\TopNPercent.rptdesign",
        "March_Report_files\\by_sup_ML.rptdesign",
        "March_Report_files\\chart__cwong.rptdesign",
        "March_Report_files\\HTML5 Chart.rptdesign",
    };
    /* Sort Sample Space */
    Arrays.sort(strArr);

    /* Initialize Result ArrayList */
    List<String> resultList = new ArrayList<>();

    /* Initialize */
    String[] strInit = strArr[0].split("\\\\");
    String prefix = strInit[0];
    StringBuilder result = new StringBuilder(strInit[1]);
    for(int i = 1; i < strArr.length; i++) {
        /* Split Using Backslash */
        String[] strSplit = strArr[i].split("\\\\");
        if(strSplit[0].equals(prefix)) {
            /* Append */
            result.append("," + strSplit[1]);
        } else {
            /* Add Result To List */
            resultList.add(result.toString());
            /* Reset Prefix, Result Strings */
            prefix = strSplit[0];
            result = new StringBuilder(strSplit[1]);
        }
    }
    /* Add Last Entry To List */
    resultList.add(result.toString());

    /* Print The Results */
    for(int i = 0; i < resultList.size(); i++) {
        System.out.println(resultList.get(i));
    }
}