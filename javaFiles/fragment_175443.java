interface Strategy {
    Data prepareData();
}

class GeneralStrategy implements Strategy {
    Data prepareData() {
        // do general preparation
    }
}

class App1Strategy extends GeneralStrategy {
    Data prepareData() {
        // do app1-specific preparation
        super.prepareData();
        // do more app1-specific preparation
    }
}