int length = 0;
for (int i = 0; i < label.length(); i++) {
    if (label[i].length() > length) {
        length = label[i].length();
    }
}

// do your stuff

System.out.printf("%" + length + "s  %-7s", label[i], a);