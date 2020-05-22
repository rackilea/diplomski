"formatVersion": 1,
  "database": {
    "version": 2,
    "identityHash": "325bd539353db508c5248423a1c88c03",
    "entities": [
      {
        "tableName": "User",
        "createSql": "CREATE TABLE IF NOT EXISTS `${TABLE_NAME}` (`id` INTEGER NOT NULL, PRIMARY KEY(`id`))",
        "fields": [
          {
            "fieldPath": "id",
            "columnName": "id",
            "affinity": "INTEGER",
            "notNull": true
          },