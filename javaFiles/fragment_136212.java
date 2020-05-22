int pkgCount = -1
try {
    pkgCount = loadDao.getPackageCount(load);
} catch (SpecificUniqueException) {
    // route to your error page for this error
}