list l1 = set1.items() //get the items out
list l2 = set2.items()

l1 = sort(l1)
l2 = sort(l2) //sort the lists

int set2idx1 = l1[0].find_closest_greater_than_value(l2) //binary search or something
if set2idx1 exists:
    l2 = l2[set2idx1+1:] //in python this means l2 is reassigned to a subarray of l2 starting at set2idx1+1 going to the end of l2
else:
    return false

for(int i=1; i<l1.len; i++)
    int set2idxi = l1[i].find_closest_greater_than_value(l2) //binary search or something
    if set2idxi exists:
        l2 = l2[set2idxi+1:]
    else
        return false

return true