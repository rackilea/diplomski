CallableStatement cs = con.prepareCall("{ call scenario.add(?,?,?,?,?) }");
cs.registerOutParameter(1, Types.INTEGER);
cs.setLong(2, cfg.getScenarioId());
cs.setString(3, cfg.getType());
String fileContent = getContent(file);
cs.setObject(4, fileContent);
cs.setString(5, cfg.getFileName());