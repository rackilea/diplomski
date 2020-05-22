package com.google.api.services.samples.dailymotion.cmdline;

import com.google.api.client.util.Key;

public class UserInfo {
  @Key
  public String issued_to;

  @Key
  public String audience;

  @Key
  public String user_id;

  @Key
  public String scope;

  @Key
  public Integer expires_in;

  @Key
  public String email;

  @Key
  public Boolean verified_email;

  @Key
  public String access_type;
}