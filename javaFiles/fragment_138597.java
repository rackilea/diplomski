taskService.executeAsync(trackingEmailId: trackingEmailId) { data ->
   Device.withTransaction{ tx ->
     TrackingEmail tEmail = TrackingEmail.get(data.trackingEmailId)
     Device targetDevice = tEmail.device
   }
}