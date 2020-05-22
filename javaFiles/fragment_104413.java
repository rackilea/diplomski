String sqlQuery = "UPDATE queue_in_progress SET DATE_TIME_TOKEN_TAKEN=?, "
        + "CE_PK=" + ce_pk
        + ", SERVICE_STATUS=1 WHERE CATEGORY_PK="
        + Category_PK
        + " AND TOKEN_NO="
        + Token_PK
        + " AND SERVICE_COUNTER="
        + service_counter + " AND SERVICE_CENTER_PK=" + service_center;