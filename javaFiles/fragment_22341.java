Object o = getSystemService("profile");
    try {

        Class<?> ProfileManager = Class.forName("android.app.ProfileManager");
        Class<?> Profile = Class.forName("android.app.Profile");
        try {

            Method getActiveProfile = ProfileManager.getDeclaredMethod("getActiveProfile", null);
            Method getName = Profile.getDeclaredMethod("getName", null);

            try {

                String strProfile = (String) getName.invoke(getActiveProfile.invoke(o));
                System.out.println("Current profile is: " + strProfile);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }           

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }