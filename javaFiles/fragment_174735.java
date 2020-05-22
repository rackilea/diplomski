String currentDBPath =
            "/data/data/com.powergroupbd.tripmileage/databases/tripmileagedatabase";
             String backupDBPath = "tripmileagedatabase";
            File currentDB = new File(data, currentDBpath);
            File backupDB = new File(sd, BackupDbPath);

            if (currentDB.exists()) {
                FileChannel src = new FileInputStream(currentDB)
                        .getChannel();
                FileChannel dst = new FileOutputStream(backupDB)
                        .getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();