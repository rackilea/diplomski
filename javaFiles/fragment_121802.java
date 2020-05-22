pb = new ProcessBuilder(
        "C:\\Program Files\\PostgreSQL\\9.3\\bin\\pg_dumpall.exe",
        "--host=localhost",
        "--port=5432",
        "--username=postgres",
        "--no-password",
        "--format=custom",
        "--blobs",
        "--verbose", "--file=D:\\service_station_backup.backup", "service_station");