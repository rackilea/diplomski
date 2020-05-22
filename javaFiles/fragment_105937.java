public List<SalaryStructure> getList() {
        list = client1.target("http://swiftworld.com/mass/web")
                .path("salarystructure")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<SalaryStructure>>() {});
        return list;
    }