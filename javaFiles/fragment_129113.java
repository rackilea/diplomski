public String appName(String pack){
        String Name = null;

        try{
            PackageManager packManager = context.getPackageManager();
            ApplicationInfo app = context.getPackageManager().getApplicationInfo(pack, 0);
            Name = packManager.getApplicationLabel(app).toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return Name;
    }