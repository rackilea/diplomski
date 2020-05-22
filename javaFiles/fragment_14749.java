for (int i = 0; i < array.size(); i++) {

    if (array.get(i) % primal == 0) array.remove(i);
}
index++;
primal = array.get(index);