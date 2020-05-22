while(resultSet.next())
{
     int iC = 0;

     environment = new Environment();
     environment.setAppName(resultSet.getString( iC++ ));
     environment.setHostName(resultSet.getString( iC++ ));
     environment.setSoftwareComponent(resultSet.getString( iC++ ));
     environment.setVersion(resultSet.getString( iC++ ));
     environment.setInstallPath(resultSet.getString( iC++ ));
     environment.setRemarks(resultSet.getString( iC++ ));
     environment.setEnvironmental(resultSet.getString( iC++ ));
     environments.add(environment);  
 }