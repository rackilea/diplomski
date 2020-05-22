public static void main(String[] args)
{
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;

    LinkedHashMap<String, Object> parentCategory = new LinkedHashMap<String, Object>();
    try {

        Class.forName("oracle.jdbc.driver.OracleDriver");  
        connection=DriverManager.getConnection(  
        "jdbc:oracle:thin:@localhost:1521:orcl","REF","REF");  
        String qstr = "select distinct PARENT_ORG_NAME from demo_org_data";
        String qstr1 = "select distinct org_lev1,org_lev2 from demo_org_data";

        pst = connection.prepareStatement(qstr);
        rs = pst.executeQuery();
        pst2 = connection.prepareStatement(qstr1);
        rs2 = pst2.executeQuery();

        while (rs.next()) {
            List<Map<String, Object>> parentList = new ArrayList<>();
            parentCategory.put("label", rs.getString(1));
            parentCategory.put("category", parentList);
            while (rs2.next()) {
                String org_lev1 = rs2.getString(1);
                String org_lev2 = rs2.getString(2);
                Map<String, Object> subCategory = searchCategoryByLabel(parentList, org_lev1);
                if (subCategory == null) {
                    subCategory = new LinkedHashMap<String, Object>();
                    subCategory.put("label", org_lev1);
                    subCategory.put("category", new ArrayList<Map<String, String>>());
                    parentList.add(subCategory);
                }
                List<Map<String, String>> subList = (List<Map<String, String>>)subCategory.get("category");
                subList.add(Collections.singletonMap("label", org_lev2));
            }
        }
    } catch (SQLException sql) {
        System.out.println("SQLException occurred while fetching the data");
    }
    catch (Exception e) {
        System.out.println("Exception occurred while fetching the data");
    }

    Map<String, List<Map<String, Object>>> outMap = 
            Collections.singletonMap("category", Collections.singletonList(parentCategory));
    System.out.println(new Gson().toJson(outMap).toString());
}

public static Map<String, Object> searchCategoryByLabel(List<Map<String, Object>> list, String label)
{
    for (Map<String, Object> map : list) {
        if (map.containsKey("label") && map.get("label").toString().equals(label)) {
            return map;
        }
    }
    return null;
}