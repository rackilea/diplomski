/**
* Set field based on key/value pair
*/
private void setValue(String key, String value) {
    switch(key) {
    case "name": {
        this.name = value;
        break;
    }
    case "age" : {
        this.age = value;
        break;
    }
    //...
    }
}