public class Car {

    @Id
    Long id;
    String name;

    Engine engine;
}

public class Truck {

    @Id
    Long id;
    String name;

    Engine engine;
}

public class Engine {

    String name;
}

CREATE TABLE CAR (
  id   BIGINT IDENTITY,
  NAME VARCHAR(200)
);

CREATE TABLE TRUCK (
  ID   BIGINT IDENTITY,
  NAME VARCHAR(200)
);

CREATE TABLE ENGINE (
  TRUCK BIGINT,
  CAR   BIGINT,
  NAME  VARCHAR(200),
  FOREIGN KEY (TRUCK) REFERENCES TRUCK (ID),
  FOREIGN KEY (CAR) REFERENCES CAR (ID)
);