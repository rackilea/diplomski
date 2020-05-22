- (void)applicationDidFinishLaunching:(UIApplication *)app {

   // other setup tasks here....

    [[UIApplication sharedApplication] registerForRemoteNotificationTypes:(UIRemoteNotificationTypeBadge | UIRemoteNotificationTypeSound)];

}