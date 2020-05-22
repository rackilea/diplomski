String SQL = "select * from ao_cc6aeb_jira_metadata";
List<JiraImportObjekt> jioList = jdbcTemplateObject.query(SQL, new JiraImportObjektMapper());
    HashMap<String, String> hmap = new HashMap<String, String>();
    Integer unique = 1;
    for (JiraImportObjekt jio : jioList) {

        hmap.put("(" + unique.toString() + ")" + jio.getEnriched_Object_Key(),
                jio.getUser_Key() + "(" + jio.getUser_Value() + ")");
        unique++;
    }