if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

        int hasCameraPermission = checkSelfPermission(Manifest.permission.CAMERA);

        List<String> permissions = new ArrayList<String>();

        if (hasCameraPermission != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.CAMERA);

        }
        if (!permissions.isEmpty()) {
            requestPermissions(permissions.toArray(new String[permissions.size()]), 111);
        }
    }