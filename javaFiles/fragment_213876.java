boolean bool = false;
int i = 0;
// entering the while loop:
if (!bool && i <= items.size() - 1) // returns true. We go in the while loop.
if (i == 0) // returns true, we go in that block.
if (check... ) // if this returns true, this happens:
    bool = true;
else // if the previous statement returns false, this happens:
    break;