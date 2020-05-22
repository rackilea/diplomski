ssize_t idx, i;
for (idx = beginning, i = 0;
     i < n_points;
     i ++, idx = (idx + 1) % n_points)
{
    // i runs from 0 ... n_points - 1
    set_pixel(i, points[idx], black);
}