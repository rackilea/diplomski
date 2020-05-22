IConnectionProfile profile = ProfileManager.getInstance().getProfileByName("QA");
Database db = getDatabase(profile);
if (db != null) {
    System.out.println("DB Vendor: " + db.getVendor());
    System.out.println("DB Version: " + db.getVersion());
}