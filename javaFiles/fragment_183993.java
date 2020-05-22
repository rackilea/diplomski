public (static?) Storage2(Context ctx) {
    //...
    File[] f = ctx.getExternalFilesDirs(null);
    //...
    this.deviceRootDir = ctx.getExternalFilesDir(null).getPath().replaceAll(replacePattern, "$1");
    }
  }