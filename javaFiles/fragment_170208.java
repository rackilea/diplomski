try (ApkFile apkFile = new ApkFile(new File(filePath))) {
    ApkMeta apkMeta = apkFile.getApkMeta();
    System.out.println(apkMeta.getLabel());
    System.out.println(apkMeta.getPackageName());
    System.out.println(apkMeta.getVersionCode());
    for (UseFeature feature : apkMeta.getUsesFeatures()) {
        System.out.println(feature.getName());
    }
}