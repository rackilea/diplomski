public Optional<DateTime> getTimeOfOldestIntervalTrafficDataMessage( MessageSource messageSource, IntegrationPeriod integrationPeriod, TrafficDataType trafficDataType )
    {
        Select select = QueryBuilder.select( "message_time" ).from( "messages", "data_message" );
        select.where( QueryBuilder.eq( "message_source_id", messageSource.getId().getId() ) )
                .and( QueryBuilder.eq( "traffic_data_type", trafficDataType.name() ) )
                .and( QueryBuilder.eq( "integration_period", integrationPeriod.name() ) );
        select.orderBy( QueryBuilder.asc( "message_time" ) );
        select.limit( 1 );

        Date date = m_cassandraOperations.queryForObject( select, Date.class );
        if( date != null )
        {
            Optional<DateTime> result = Optional.of( new DateTime( date ) );
            logger.debug( "oldest interval: {} ({}/{}/{})", result, messageSource.getName(), trafficDataType, integrationPeriod );
            return result;
        }
        else
        {
            return Optional.absent();
        }
    }