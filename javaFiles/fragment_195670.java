Set<PosixFilePermission> filePermission = new HashSet<PosixFilePermission>();

    // OWNER rwe --- ---
    filePermission.add(PosixFilePermission.OWNER_READ);
    filePermission.add(PosixFilePermission.OWNER_WRITE);
    filePermission.add(PosixFilePermission.OWNER_EXECUTE);

    // GROUP --- rwe ---
    filePermission.add(PosixFilePermission.GROUP_READ);
    filePermission.add(PosixFilePermission.GROUP_WRITE);
    filePermission.add(PosixFilePermission.GROUP_EXECUTE);

    // GLOBAL --- --- rwe
    filePermission.add(PosixFilePermission.OTHERS_READ);
    filePermission.add(PosixFilePermission.OTHERS_WRITE);
    filePermission.add(PosixFilePermission.OTHERS_EXECUTE);

    Files.setPosixFilePermissions(Paths.get("{PATH_TO_FILE}"), filePermission);