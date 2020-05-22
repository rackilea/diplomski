for (int i =0;  i<max(X.size(),Y.size()); i++){
  if(i<X.size() && i<Y.size()) {
    print(X.get(i) + " " + Y.get(i));
  } else if(i<Y.size()) {
    print(Y.get(i));
  } else {
    print(X.get(i));
  }
}