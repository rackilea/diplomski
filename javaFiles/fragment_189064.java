StringBuilder sbUserRegQuery = new StringBuilder();
sbUserRegQuery.append("INSERT INTO users (username, password , email, enabled, datetime_condo_changed, datetime_last_login");
if(user.getCondo_id()!=null) sbUserRegQuery.append(", condo_id");
if(user.getProvider()!=null) sbUserRegQuery.append(", provider");
sbUserRegQuery.append(")");
sbUserRegQuery.append(" VALUES ( ?, ?, ? , ? , ?, ?");
if(user.getCondo_id()!=null) sbUserRegQuery.append(", ?");
if(user.getProvider()!=null) sbUserRegQuery.append(", ?");
sbUserRegQuery.append(");");

ArrayList<Object> params = new ArrayList<Object>();
params.add(user.getUsername());
params.add(PasswordEncoderGenerator.main(user.getPassword()));
params.add(user.getEmail());
params.add(enabled);
params.add(user.getDatetime_condo_changed());
params.add(currentTimeStamp);
if(user.getCondo_id()!=null) params.add(user.getCondo_id());
if(user.getProvider()!=null) params.add(user.getProvider());

int row = getJdbcTemplate().update(sbUserRegQuery.toString(), params.toArray());