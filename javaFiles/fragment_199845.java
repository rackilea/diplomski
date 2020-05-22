public static Result update() {
    Form<Device> deviceForm = Form.form(Device.class).bindFromRequest();

    if (deviceForm.hasErrors()) {
        return badRequest(views.html.Devices.edit.render(deviceForm, listOfRoles()));
    }

    // Form is OK, has no errors, we can proceed
    Device device = deviceForm.get();
    device.update(device.id);
    return redirect(routes.Devices.index());
}