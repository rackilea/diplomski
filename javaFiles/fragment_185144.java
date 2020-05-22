DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig
                    .builder()                
                    .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNamePrefix(environment + "."))
                    .withConversionSchema(ConversionSchemas.V2)
                    .build();

client.getMapper().load(DBActivity.class, id, mapperConfig)