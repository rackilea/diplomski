try {
        ZipResourceFile expansionFile = APKExpansionSupport
                .getAPKExpansionZipFile(this, 4, 0);

        ZipEntryRO[] zip = expansionFile.getAllEntries();
        Log.e("", "zip[0].isUncompressed() : " + zip[0].isUncompressed());
        Log.e("",
                "mFile.getAbsolutePath() : "
                        + zip[0].mFile.getAbsolutePath());
        Log.e("", "mFileName : " + zip[0].mFileName);
        Log.e("", "mZipFileName : " + zip[0].mZipFileName);
        Log.e("", "mCompressedLength : " + zip[0].mCompressedLength);

        File file = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "");
        ZipHelper.unzip(zip[0].mZipFileName, file);

        if (file.exists()) {
            Log.e("", "unzipped : " + file.getAbsolutePath());
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @Override
    protected void onDestroy() {
        this.mCancelValidation = true;
        super.onDestroy();
    }