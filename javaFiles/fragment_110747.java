public static void setProfile(ProfileModel profile) {
    Controller.profile = profile;

    for(ControllerUpdateListener l : updateListeners) {
        l.onControllerUpdate(profile);
    }
}