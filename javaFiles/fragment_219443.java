public Builder packages(Class<?>... basePackageClasses) {
        Set<String> packages = new HashSet<>();
        for (Class<?> type : basePackageClasses) {
            packages.add(ClassUtils.getPackageName(type));
        }
        this.packagesToScan = StringUtils.toStringArray(packages);
        return this;
    }