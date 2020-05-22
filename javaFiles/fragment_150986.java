ArrayList<Service> allServices = new ArrayList<>();
allServices.add(camera);
allServices.add(music);
allServices.add(video);
allServices.add(hotel);
allServices.add(transport);
allServices.add(car);

for(Service obj : allServices)
    System.out.print(obj.name + " costs " + obj.cost);