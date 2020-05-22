// looping through All Contacts
        for (int i = 0; i < classes.length(); i++) {
            JSONObject c = classes.getJSONObject(i);

            prgmNameList.add("lesson_" + c.getString("id"));
            caseList.add(c.getString("course"));
            dateList.add(c.getString("date"));
        }

        adapter.notifyDataSetChanged();

        return "Load Complete";