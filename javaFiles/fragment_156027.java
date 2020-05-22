/**
         * Get class file location
         * @param path : example: com.test.Class1
         * @return : example: /D:/workspace/project/target/com/test/Class1.class
         * @throws ClassNotFoundException
         */
        private static String getFileLocationByClassName(String path) 
            throws ClassNotFoundException {
            if (path == null || path.length() == 0)
                return "";
            Class<?> forName = Class.forName(path);
            URL resource = forName.getResource(forName.getSimpleName() + ".class");
            if (!"file".equalsIgnoreCase(resource.getProtocol()))
                throw new IllegalStateException("Class is not stored in a file.");
            return resource.getPath();
        }