public class FilterTest {
    public static int COLS_PER_RECORD = 3;

    public static void main(String[] args) {
        ArrayList dataList = populateTestData();
        printRecords(dataList);
        ArrayList filtered = filterForClassId(dataList, 2);
        printRecords(filtered);
    }

    private static ArrayList populateTestData() {
        ArrayList dataList = new ArrayList();
        ResultSet rs = s.getResultSet();
        while (rs.next()) {
            dataList.add(rs.getInt("class_id"));
            dataList.add(rs.getString("name"));
            dataList.add(rs.getString("student_id"));
        }
        return dataList;
    }

    private static ArrayList filterForClassId(ArrayList dataList,
            int classIdToFilterFor) {
        ArrayList filtered = new ArrayList();
        Integer classIdToFilterForInteger = new Integer(classIdToFilterFor);
        for (int i = 0; i < dataList.size(); i += COLS_PER_RECORD) {
            if (classIdToFilterForInteger.equals(dataList.get(i))) {
                for (int j = 0; j < COLS_PER_RECORD; j++) {
                    filtered.add(dataList.get(i + j));
                }
            }
        }
        return filtered;
    }

    private static void printRecords(ArrayList dataList) {
        System.out.println("----");
        for (int i = 0; i < dataList.size(); i += COLS_PER_RECORD) {
            System.out.println("class_id=" + dataList.get(i) + " name="
                    + dataList.get(i + 1) + " student_id="
                    + dataList.get(i + 2));
        }
        System.out.println("----");
    }
}