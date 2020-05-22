DriverLocationEntity driverLocationEntity = new DriverLocationEntity();
        driverLocationEntity.setDriverId(messageEntity.getDriverId());
        driverLocationEntity.setPoint(new Point(messageEntity.getLongitude(), messageEntity.getLatitude()));
        driverLocationEntity.setUpdatedAt(new Date(now));
        driverLocationEntity.setId(UUID.randomUUID().toString());

        // add hash_id into geoset for distance calculations
        redissonClient.getGeo(GEO_SET_KEY_NAME, new StringCodec()).add(messageEntity.getLongitude(), messageEntity.getLatitude(), HASH_ID_PREFIX + driverLocationEntity.getId());