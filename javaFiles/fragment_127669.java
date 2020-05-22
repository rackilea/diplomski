ICustomAdapterListener customAdapterListener = new ICustomAdapterListener() {
    @Override
    public void openContactDetail(String currName, String currNumber) {
        Intent intent = new Intent(context, ContactDetails.class);
        intent.putExtra("contactName", currName);
        intent.putExtra("contactPhone", currNumber);
        startActivity(intent);
    }
};