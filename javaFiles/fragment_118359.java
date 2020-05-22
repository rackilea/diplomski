boolean alreadyAdded = false;

for (int i = 0; i < data.size(); i++) {
    if (data.get(i).equals(x)) {
        alreadyAdded = true;
        break;
    }
}

if (!alreadyAdded) {
    data.add(x);
}