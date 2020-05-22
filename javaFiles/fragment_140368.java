// Earlier than 1985 in Unix, must be Apple
if(date < 473410800) {
    m.date = new Date((date + 978307200L) * 1000);
} else {
    m.date = new Date(date * 1000);
}