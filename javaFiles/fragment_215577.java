QDevice device = QDevice.device;
QDevice parentDevice = new QDevice("parentDevice");
List<Device> list = new JPAQuery(entityManager)
    .from(device)
    .leftJoin(device.parentDevice, parentDevice)
    .list(Projections.bean(Device.class, device.id, parentDevice));