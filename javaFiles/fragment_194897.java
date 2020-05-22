template <typename T> 
class Dispatcher { 
private: 
    std::list<T> listeners; 
    std::function<void(T)> caller;

public: 
    Dispatcher(function<void(T)> caller) : caller(caller) {} 

    void add(T listener) { 
        listeners.push_back(listener); 
    } 

    void dispatch() { 
        // listeners loop 
        for(typename std::list<T>::iterator pos = listeners.begin(); pos != listeners.end(); pos++) 
        {
            caller(*pos);
        }
    } 
}; 

Dispatcher<IBookUpdatedHandler*> *dispatcher1 = new Dispatcher<IBookUpdatedHandler*>( 
    [](IBookUpdatedHandler* p) { p->updateBook(0); } 
); 

Dispatcher<IBookFiredHandler*> *dispatcher2 = new Dispatcher<IBookFiredHandler*>( 
    [](IBookFiredHandler* p) { p->fireBook(0); } 
);