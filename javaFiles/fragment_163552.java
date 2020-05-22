for (Map.Entry<String, byte[]> entry : fileMap.entrySet()){

            TarArchiveEntry tarArchiveEntry = new TarArchiveEntry(entry.getKey());
            tarArchiveEntry.setSize(entry.getValue().length);

            try {
                outTar.putArchiveEntry(tarArchiveEntry);
                outTar.write(entry.getValue());
                outTar.closeArchiveEntry();   ////////  <-----------

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            outTar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }