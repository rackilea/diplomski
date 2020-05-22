package com.google.gwt.sample.stockwatcher.client;

import java.io.Serializable;
import java.util.Date;

public class StockClient implements Serializable {

  private Long id;
  private String symbol;
  private Date createDate;

  public StockClient() {
    this.createDate = new Date();
  }

  public StockClient(String symbol) {
    this.symbol = symbol;
    this.createDate = new Date();
  }

  public StockClient(Long id, String symbol, Date createDate) {
    this();
    this.id = id;
    this.symbol = symbol;
    this.createDate = createDate;
  }

  public Long getId() {
      return this.id;
  }

  public String getSymbol() {
      return this.symbol;
  }

  public Date getCreateDate() {
      return this.createDate;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setSymbol(String symbol) {
      this.symbol = symbol;
  }
}