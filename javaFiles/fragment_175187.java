public void getAllDevices() throws Exception {
        List<Device> devicesList = (List<Device>) session.createQuery("SELECT device " +
            "FROM Device As device " +
                "INNER JOIN device.site " +
                "INNER JOIN device.site.technology " +
                "INNER JOIN device.site.country " +
            "WHERE device.site.country.countryCode = 'ES'").list();
        int size = devicesList.size();
        System.out.println("Size was " + size);
        for(int i=0; i<size; i++){
            System.out.println(d.getDeviceOperationsName() + " in site " + d.getSite().getSiteName()
                    + " with technology " + d.getSite().getTechnology().getTechnologyName()
                    + " in country " + d.getSite().getCountry().getCountryName());
        }
}