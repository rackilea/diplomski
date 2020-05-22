@Override
public boolean doesRegionExist(int userId, List<Integer> regionIds) {
    HashMap<String, Object> paramMap = new HashMap<String, Object>();
    paramMap.put("userId", analystId);
    paramMap.put("regionIds", regionIds);

    SqlRowSet result = namedParameterJdbcTemplate.queryForRowSet("SELECT * FROM USER_REGION_TABLE WHERE STATUS = 0 AND USER_ID = (:userId) AND REGION_ID IN (:regionIds)", paramMap);

        if (result.next())
            return true;
        else
            return false;

    }