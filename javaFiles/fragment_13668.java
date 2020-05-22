interface IAPIEndpoint {
    MyDomainDataEntity getData();
}

class MyAPIEndpoint : IAPIEndpoint {

    public MyDomainDataEntity getData() {
        MyDomainDataEntity dataEntity = new MyDomainDataEntity();
        // Call the third party api and fill it
        return dataEntity;
    }
}