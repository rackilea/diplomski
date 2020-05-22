try {
            JSONObject res = new JSONObject(response);

            if (res.getString("status").equalsIgnoreCase("success")) {
                JSONObject obj = res.getJSONObject("data");
                JSONArray rootCauseIdentificationArray = obj.getJSONArray("root_cause_identification");
                for(int i = 0; i<rootCauseIdentificationArray.length(); i++){
                    JSONObject objData = rootCauseIdentificationArray.getJSONObject(i);
                    //iterate the object here and add to the list
                    RootCauseIdentificationModel model = new RootCauseIdentificationModel( objData.getString("id"), objData.getString("root_cause_identified"), objData.getString("solution_implemented"), objData.getString("implementaion_date"));
                   dataList.add(model);

                }

                stepsList.add(new TQMSavedDataModel(obj.getString("tangible_benefits"),
                        obj.getString("intangible_benefits"),
                        obj.getString("total_annual_savings"),
                        dataList));
                tangibleBenefits.setText(obj.getString("tangible_benefits"));
                intangibleBenefits.setText( obj.getString("intangible_benefits"));
                annualAmount.setText(obj.getString("total_annual_savings"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            dialog.dismiss();
            Toast.makeText(getActivity(), "Something went wrong, please try again.", Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }