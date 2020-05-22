if (free space == 0)
    print success with placements
    ++solution count
    return;
for every candidate:
    if (candidate fits here)
        place candidate here
            recurse (candidates without candidate)
        remove candidate here