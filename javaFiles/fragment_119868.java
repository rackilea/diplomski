class MessageBuilder {
    String address = "unknown";
    String state = "unknown";
    String country = "unknown";

    MessageBuilder() {}


    String show() {
        return address + ", " + state + ", " + country;
    }

    MessageBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    MessageBuilder setState(String state) {
        this.state = state;
        return this;
    }

    MessageBuilder setCountry(String country) {
        this.country = country;
        return this;
    }
}