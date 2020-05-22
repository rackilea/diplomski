package de.scrum_master.app;

public class ServiceInput {
    private String id;
    private String detail;

    public ServiceInput(String id) { this.id = id; }
    public void setDetail(String detail) { this.detail = detail; }
    @Override public String toString() { return "ServiceInput [id=" + id + ", detail=" + detail + "]"; }
}