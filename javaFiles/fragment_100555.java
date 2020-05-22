class ConcreteFactoryA implements AbstractFactory {

    public APIParser createAPIParser() { return new APIParserA(); }
    public APIClient createAPIClient() { return new APIClientA(); }
}

class ConcreteFactoryB implements AbstractFactory {

    public APIParser createAPIParser() { return new APIParserB(); }
    public APIClient createAPIClient() { return new APIClientB(); }
}