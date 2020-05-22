public int find(int p)
{   int curr = p;
    while (curr != id[curr]) curr = id[curr]; //find root
    //at this point, curr is the root
    while (p != id[p]) { 
        int next = id[p];
        id[p] = curr; //remember, curr is the root
        p = next;
    }
}