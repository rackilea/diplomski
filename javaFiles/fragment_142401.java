class Table {
public:
    std::vector<Row> rows;
}

class Row {
public:
    std::vector<Cell> cells;
}

class Cell {
public:
     int intValue;
     double doubleValue;
     // Etc
     enum Datatype {...};
     Datatype datatype;
}