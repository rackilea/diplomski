private static void getFromDatabase() {

        Map<String, String> hello = new LinkedHashMap<String, String>();            

        String version0 = "1.0.0";
        String version1 = "1.0.0";
        String version2 = "1.0.0";

        hello.put("Framework", version0);
        hello.put("BundleA", version1);
        hello.put("BundleB", version2);

        //The following code will update bundleList only when it's different from hello
        if (!bundleList.isEmpty()) {
            if (bundleList.get("Framework") != hello.get("Framework"))
                bundleList.put("Framework", version0)
            if (bundleList.get("BundleA") != hello.get("BundleA"))
                bundleList.put("BundleA", version1)
            if (bundleList.get("BundleB") != hello.get("BundleB"))
                bundleList.put("BundleB", version2)
        }
        else { //if this is the first time
            bundleList.put("Framework", version0)
            bundleList.put("BundleA", version1)
            bundleList.put("BundleB", version2)
        }
    }