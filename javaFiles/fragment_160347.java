DataSource content = new DataSource()
                            .setApplication(YOUR_APPLICATION)
                            .setType(DATA_SOURCE_RAW)
                            .setName(name)
                            .setDataType(dataType);

Fitness.Users.DataSources.Create request = 
         service.users().dataSources().create("me", content);

DataSource ds = request.execute();