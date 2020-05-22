final Query query = entityManager.createNativeQuery("INSERT INTO mams_asset a ( a.mams_asset_id, a.mams_folder_id, a.asset_name, a.gist, a.last_modified_date, " +
                "a.last_exported_date, a.created_date ) VALUES (hextoraw(?), hextoraw(?), ?, ?, ?, ? , ?)")
                .setParameter(1, mamsAssetId)
                .setParameter(2, mamsFolderId)
                .setParameter(3, assetName)
                .setParameter(4, gist)
                .setParameter(5, lastModifiedDate, TemporalType.TIMESTAMP)
                .setParameter(6, lastExportedDate, TemporalType.TIMESTAMP)
                .setParameter(7, createdDate, TemporalType.TIMESTAMP);