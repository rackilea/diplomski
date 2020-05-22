String orderDateString = cOrder.getOrderDate();
try {
    Date now = new Date();
    Date orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
            Locale.getDefault()).parse(orderDateString);

    if(orderDate.before(now)) {
        holder.btnCancel.setVisibility(View.GONE);
    }
} catch (ParseException pe) {
    pe.printStackTrace();
}