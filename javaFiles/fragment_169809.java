Gson gson = new Gson();
   List<Consultation> consultations= gson.fromJson(json, new TypeToken<List<Consultation>>(){}.getType());
    for (Consultation consultation: consultations) {
        Log.e("TEST","Consultation id : " + consultation.getConsulationId());
        Log.e("TEST","Patient id: " + consultation.getPatientid());
    }