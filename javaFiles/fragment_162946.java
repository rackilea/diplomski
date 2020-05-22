// Using NULL and pointers for first and last

n->next = x;
n->prev = x ? x->prev : last;
if (n->prev) n->prev->next = n;
        else first = n;
if (n->next) n->next->prev = n;
        else last = n;