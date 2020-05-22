try {
        JSONObject jsonObject = new JSONObject(strJson);
        JSONArray jsonArr = jsonObject.getJSONArray("Employee");
        Log.d("jsonArrayLength: ", "Length: "+ jsonArr.length());

        for (int i = 0; i < jsonArr.length(); i++) {
            Employee emp = new Employee();
            JSONObject empObj = jsonArr.getJSONObject(i);
            String name = empObj.getString("name");
            String id = empObj.getString("id");
            String salary = empObj.getString("salary");
            emp.setId(id);
            emp.setName(name);
            emp.setSalary(salary);
            item.add(i,name);
            employ.add(i,emp);
        }

    }
    catch (JSONException e){
        e.printStackTrace();
    }