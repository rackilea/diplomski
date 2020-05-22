Collections.sort(list, new Comparator<Patient_Get_Set>() {
        @Override
        public int compare(final Patient_Get_Set object1, final Patient_Get_Set object2) {
            List<String> statusList = new ArrayList();
            statusList.add("consultation");statusList.add("queue"); statusList.add("waiting");
            return new Integer(statusList.indexOf(object1.getConsultation_status())).compareTo(new Integer(statusList.indexOf(object2.getConsultation_status())));
            }
        });