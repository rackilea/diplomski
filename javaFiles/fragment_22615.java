LinkedInAccountObject lao = new LinkedInAccountObject();
//counter++; remove it from here.
lao.setAccountId(rs.getLong("account_id"));

lao.setLinkedInAccountId(rs.getString("linkedin_account_id"));
lao.setParentId(rs.getLong("parent_id"));
lao.setFirstName(rs.getString("first_name"));

lao.setLinkedInAccountId(rs.getString("linkedin_account_id"));
lao.setEmail(rs.getString("email"));
lao.setAccessToken(rs.getString("access_token"));
lao.setExpiresOn(rs.getLong("expires_on"));

laoarray.add(counter, lao);
counter++;//place it here