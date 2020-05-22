pb = new ProcessBuilder(
        "C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dumpall.exe",
        "--dbname=postgres://postgres:password@localhost/postgres",
        "--format=custom",
        "--blobs",
        "--verbose", "--file=D:\\service_station_backup.backup", "service_station");