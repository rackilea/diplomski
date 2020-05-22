for (String doctorId : groupedDoctorsKeySet) {
        List<Doctor> dctrs = groupedDoctors.get(doctorId);

        Double total_payment = 0d;
        String doctor_name = null;
        for (Doctor doctor : dctrs) {
            if (doctor_name == null) {
                doctor_name = doctor.doctor_name;
            }
            total_payment += doctor.doctor_payment;
        }
        Doctor doctor = new Doctor(doctorId, doctor_name, total_payment);
        System.out.println("ID : " + doctor.doctor_id + "\t" + "Name : " + doctor.doctor_name + "\ttotal_Payment : " + doctor.doctor_payment);
    }