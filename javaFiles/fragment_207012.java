BoundStatement boundStatement = new BoundStatement(statement);
boundStatement.setString(0, dto.getHost());
boundStatement.setString(1, dto.getTrigger());
Timestamp ts = Timestamp.valueOf(dto.getEventTime());
boundStatement.setDate(2, ts);
boundStatement.setString(3, dto.getUIDDefault());