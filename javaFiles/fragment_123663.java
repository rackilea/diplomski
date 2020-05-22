HashMap<String, String> verify = new HashMap<String, String>();
while (rs.next())
{
    verify.put("beneficiaryID",rs.getString("beneficiaryID"));
    verify.put("scheme", rs.getString("scheme"));
    verify.put("aadhaar",rs.getString("aadhaar"));
    verify.put("name",rs.getString("name"));
}