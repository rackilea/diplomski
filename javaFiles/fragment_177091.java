//singleton
for (int i = 0; i < l.size(); i++) {
    System.out.println(l.get(i));
}

//pairs
for (int i = 0; i < l.size(); i++) {
    for (int j = i+1; j < l.size(); j++) {
        System.out.println(l.get(i)+l.get(j));
    }
}

//3-tuple
for (int i = 0; i < l.size(); i++) {
    for (int j = i+1; j < l.size(); j++) {
        for (int k = j+1; k < l.size(); k++) {
            System.out.println(l.get(i)+l.get(j)+l.get(k));
        }
    }
}
// ...
//k-tuple