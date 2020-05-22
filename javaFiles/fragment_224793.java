public static String getUnitInfo(Connection connection, Statement stmt, ResultSet rs) throws SQLException, ClassNotFoundException
{
    StringBuilder unitinfo = new StringBuilder();

    ...

    while(rs.next()) {

        ...

        unitinfo.append("<CLAIM_UNIT_INFO>");

        //Create one large string that incorporates all of the above nodes
        String unitinfo1 =  CL_UNIT_YEAR + CL_UNIT_TYPE + CL_UNIT_SUB_TYPE + CL_UNIT_CATEGORY + CL_UNIT_IDENTIFIER +
                            CL_UNIT_NUM + CL_UNIT_MAKE + CL_UNIT_MODEL + CL_UNIT_VEH_ID + CL_UNIT_DESC1 + TAG_NUMBER + DAMLOC + DAMDESC +
                            UNIT_TYPE + UNIT_SUB_TYPE + UNIT_CATEGORY + UNIT_IDENTIFIER + UNIT_NUMBER + UNIT_YEAR + UNIT_MAKE +
                            UNIT_MODEL + VEH_ID + ITEM_DESC + COVERAGE_TYPE + DED_TYPE_CODE1 + DEDUCTIBLE1 + DED_TYPE_CODE2 +
                            DEDUCTIBLE2 + DED_TYPE_CODE3 + DEDUCTIBLE3 + LIMIT_TYPE1 + LIMIT1 + LIMIT_TYPE2 + LIMIT2 +
                            LIMIT_TYPE3 + LIMIT3 + LIMIT_TYPE4 + LIMIT4;

        unitinfo.append(unitinfo1);
        unitinfo.append("</CLAIM_UNIT_INFO>");
    }

    ...

    return unitinfo.toString();

}