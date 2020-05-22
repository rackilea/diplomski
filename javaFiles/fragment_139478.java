do {
    sum = 0;
    do {
        b = ui % 10;
        ui = ui / 10;
        sum += b;

    } while (ui > 9);
    sum += ui;

    ui = sum;
    count++;

} while (ui > 9);

System.out.print(count);