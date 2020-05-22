List results = new ArrayList<Map<String, String>>();
while (rs.next())
{
    Map<String, String> verify = new HashMap<String, String>();
    verify.put("beneficiaryID",rs.getString("beneficiaryID"));
    verify.put("scheme", rs.getString("scheme"));
    verify.put("aadhaar",rs.getString("aadhaar"));
    verify.put("name",rs.getString("name"));
    results.add(verify);
}
 request.setAttribute("verify", results);