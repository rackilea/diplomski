const direction = (x1, y1, x2, y2) => {
    let d = "";
    d += y1 < y2 ? "N" : y1 > y2 ? "S" : "";
    d += x1 < x2 ? "E" : x1 > x2 ? "W" : "";
    return d === "" ? "here" : d;
};

console.log(direction(1, 2, 3, 4)); //NE
console.log(direction(4, 2, 5, 1)); //SE
console.log(direction(0, 0, 0, 1)); //N
console.log(direction(3, 2, 1, 1)); //SW
console.log(direction(0, 1, 2, 1)); //E
console.log(direction(0, 0, 0, 0)); //here