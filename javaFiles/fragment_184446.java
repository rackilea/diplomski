package de.professional_webworkx.jackson.jacksondemo.domain;

import java.io.Serializable;
import java.util.Random;

public class Position implements Serializable {

private Long id;
private double lat;
private double lon;

protected Position() {}

public Position(final double lat, final double lon) {
    this.id     = generateId();
    this.lat    = lat;
    this.lon    = lon;
}

private Long generateId() {
    Random random = new Random(System.currentTimeMillis());
    return random.nextLong();
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public double getLat() {
    return lat;
}

public void setLat(double lat) {
    this.lat = lat;
}

public double getLon() {
    return lon;
}

public void setLon(double lon) {
    this.lon = lon;
}