public boolean isCommandEnabled(String commandId) {
    final IWorkbenchActivitySupport activitySupport = PlatformUI.getWorkbench().getActivitySupport();
    final IActivityManager activityManager = activitySupport.getActivityManager();

    for (String activityId : (Set<String>) activitySupport.getActivityManager().getDefinedActivityIds()) {
        // we iterate through all activities...
        IActivity activity = activityManager.getActivity(activityId);
        for (IActivityPatternBinding activityBinding : (Set<IActivityPatternBinding>) activity.getActivityPatternBindings()) {
            // ...and check if one of the bindings match the command...
            if (isMatch(activityBinding, commandId) && !activity.isEnabled()) {
                // ... to get the command's enablement
                return false;
            }
        }
    }
    // if no activity was found to disable the command, it's enabled by default
    return true;
}

private static boolean isMatch(IActivityPatternBinding activityBinding, String toMatch) {
    return activityBinding.getPattern().matcher(toMatch).matches();
}