Dictionary dict = new Dictionary();

dict.insert("word", new Integer(42));

Object count = dict.find("word"); // gives an Object, not an Integer

// need to cast - annoying, not safe
Integer countAsInteger = (Integer)count;