dashboardCreateSupport_sectionSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
 Constants.supportListResponse.getRes().getSections().get(position).getId();
            }
        });