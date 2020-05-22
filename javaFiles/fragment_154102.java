interface Publisher {
    void addSubscriber(Subscriber sub);
}

interface Subscriber {
    void handle (Object event);
}

class A implements Publisher, Subscriber {...}
class B implements Publisher, Subscriber {...}