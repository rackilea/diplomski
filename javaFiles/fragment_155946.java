List<Map<String, Object>> response = new ArrayList<>();// JDK7++
 while (rSet.next()) 
            {
                Map<String, Object> row = new HashMap<>;
                row.put("CARD_NUMBER",  rSet.getString("CARD_NUMBER"));
                // this wil be null safe
                ...
                response.add(row);
            }