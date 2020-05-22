try {


            JSONArray jsonArray=new JSONArray(jsonStr);

            JSONObject jsonObj =jsonArray.getJSONObject(0);

            // Getting JSON Array node
            JSONArray employees = jsonObj.getJSONArray("employee");

            // looping through All Contacts
            for (int i = 0; i < employees.length(); i++) {
                JSONObject c = employees.getJSONObject(i);
                String firstName = c.getString("firstName");
                String lastName = c.getString("lastName");
                String designation = c.getString("designation");
                String city = c.getString("city");
                HashMap<String, String> emp = new HashMap<>();
                emp.put("firstName", firstName);
                emp.put("lastName", lastName);
                emp.put("designation",designation);
                emp.put("city",city);
                employeeList.add(emp);
            }
        } catch (final JSONException e) {

        }