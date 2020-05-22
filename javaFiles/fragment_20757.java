abstract class Resource {   
}

class WorkResource extends Resource {
    public WorkResource(Person person) {
        ***********
    }
}

class HomeResource extends Resource {
    public HomeResource(Person person) {
        ***********
    }
}

Map<PhoneType, List<Resource>> contacts = personList.stream().collect(Collectors.groupingBy(p->p.getPhoneType, Collectors.mapping(Resource::new)));