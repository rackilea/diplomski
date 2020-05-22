private JSONArray removeDuplicate(JSONArray rubricReportArray) throws Exception{
        Log.e("MethodEntered", "success");
        JSONArray tempArray = new JSONArray();
        try {
            JSONObject tempStudentObj = null;
            for (int i = 0; i < rubricReportArray.length(); i++) {
                JSONObject studentObj = rubricReportArray.getJSONObject(i);


                tempStudentObj = new JSONObject();
                tempStudentObj.put("student_name", studentObj.getString("student_name"));
                tempStudentObj.put("lessonplan_name", studentObj.getString("lessonplan_name"));
                tempStudentObj.put("student_id", studentObj.getString("student_id"));
                tempStudentObj.put("lessonplan_subject", studentObj.getString("lessonplan_subject"));
                tempStudentObj.put("student_marks", studentObj.getString("student_marks"));
                tempStudentObj.put("lessonplan_class", studentObj.getString("lessonplan_class"));


                JSONArray duplicateArray = studentObj.getJSONArray("lessaon_plan_data");
                JSONArray uniqueArray = new JSONArray();
                int k;
                for (int j = 0; j < duplicateArray.length(); j++) {
                    boolean flag = false;
                    String lessonMarks = duplicateArray.getJSONObject(j).getString("lessonplan_marks");
                    String lessonName = duplicateArray.getJSONObject(j).getString("lessonplan_name");
                    String lessonSubject = duplicateArray.getJSONObject(j).getString("lessonplan_subject");
                    for (k = j + 1; k < duplicateArray.length() - 1; k++) {

                        String currentLessonMarks = duplicateArray.getJSONObject(k).getString("lessonplan_marks");
                        String currentLessonName = duplicateArray.getJSONObject(k).getString("lessonplan_name");
                        String currentLessonSubject = duplicateArray.getJSONObject(k).getString("lessonplan_subject");

                        if (lessonMarks.equalsIgnoreCase(currentLessonMarks) && (lessonSubject.equalsIgnoreCase(currentLessonSubject) &&
                                lessonName.equalsIgnoreCase(currentLessonName) 
                               ){
                            break;
                        }


                    }
                    if (k == duplicateArray.length() - 1){
                        uniqueArray.put(duplicateArray.getJSONObject(j));
                    }
                }
                tempStudentObj.put("lessaon_plan_data", uniqueArray);
                Log.e("TempStudent", tempStudentObj.toString());
                tempArray.put(tempStudentObj);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tempArray; //assign temp to original

    }