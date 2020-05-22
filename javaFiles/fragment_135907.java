if (service_type.equals("support")){
    DocumentReference docRef = firestore_popup.collection("param_data_app").document("support_case_numbers");
    docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
     @Override
     public void onComplete(@NonNull Task<DocumentSnapshot> task) {
            if (task.isSuccessful()) {
                 DocumentSnapshot document = task.getResult();
                 String consecutive = document.get("consecutive").toString();
                    if (consecutive.equals(null)) {
                         int random = new Random().nextInt(117) + 4;
                         case_number_consecutive = "IOC-09"+random;
                    } else {
                        case_number_consecutive = consecutive;                                        UpdateCaseNumbersConsecutive("support");
                    }
             } else {
                  int random = new Random().nextInt(117) + 4;
                  case_number_consecutive = "IOC-09"+random;
              }
      }
     });
}