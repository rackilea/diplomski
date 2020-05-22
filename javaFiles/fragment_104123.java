LobHandler lobHandler = new DefaultLobHandler();
List<FrontendData> frontEndDataList = jdbcTemplate.query(getResponseQuery(sessionId), new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                // TODO Auto-generated method stub

                FrontendData frontEndData = new FrontendData();
                String operationName = rs.getString("OPERATION_NAME");
                frontEndData.setApiName(operationName);
                byte[] requestData = lobHandler.getBlobAsBytes(rs,"RESPONSE_MESSAGE");
                frontEndData.setResponse(new String(requestData));


                return frontEndData;
            }});