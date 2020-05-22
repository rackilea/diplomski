public ResponseEntity<Void> changeStatus(@PathVariable final List<Integer> ids, @NotNull @RequestBody final Device device) {
    try {
        deviceService.updateStatus(ids, DeviceStatus.valueOf(device.getStatus()));
    } catch(IllegalArgumentException ex) {
        // throw some custom exception. device.getStatus() was invalid
    } catch(NullPointerException ex) {
        // throw some custom exception. device.getStatus() was null
    }
    // ...