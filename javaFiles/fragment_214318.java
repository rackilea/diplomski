try {
        final TConfig config = TConfig.get();

        // Request encryption in archive files.
        config.setOutputPreferences(config.getOutputPreferences()
                .or(BitField.of(FsOutputOption.ENCRYPT)));

        // Configure archive detector with custom key management for ZIP files.
        config.setArchiveDetector(newArchiveDetector1("zip", "password"));

        // Setup file paths.
        TFile src = new TFile("file1");
        TFile dst = new TFile("file2");
        if (dst.isArchive() || dst.isDirectory())
            dst = new TFile(dst, src.getName());

        // Recursive copy.
        src.cp_rp(dst);
    } finally {
        // Commit changes.
        TVFS.umount();
    }