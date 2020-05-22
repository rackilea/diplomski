try { 
    if(FragmentItemHoroscopePage.getAdapter() != null) {
        System.out.println("REFRESH");
        FragmentItemHoroscopePage.getAdapter().notifyDataSetChanged();
    }
} catch (Exception e) {
    e.printStackTrace();
}