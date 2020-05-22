@DeleteMapping(value = "/devices/{id}")
public String deleteOne(@PathVariable("id") long id, @ModelAttribute("devices") List<Device> devices) {
    deviceService.deleteOne(id);
    devices.remove( /* just deleted device */);
    return "index :: devices";
}