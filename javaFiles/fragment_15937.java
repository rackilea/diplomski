@GetMapping(path = "/users/notifications", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<UserNotification>> userNotifications(
            @RequestHeader(value = "Authorization") String authHeader) {

        User user = authUserOnPath("/users/notifications", authHeader);

        List<UserNotification> menuAlertNotifications = menuService
                .getLast365DaysNotificationsByUser(user);


        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(menuAlertNotifications);


    }