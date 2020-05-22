if (n<list1.size() && list1.size() == list2.size()) {
    if (list1.get(n).equals((list2.get(n)))) 
        return true; // don't return true here, since you just tested one element
    else
        return false;
}
return isEqual(list1, list2, n + 1);