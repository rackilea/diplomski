ArrayList<SubOrderItemDetail> subOrderDetailList = orderDetail.getSubOrderDetail();
for (int j = 0; j < orderDetailList.size(); j++) {
  System.out.println("Sub Order Detail --->");
  SubOrderItemDetail subOrderDetail = subOrderDetailList.get(j);
  System.out.println("Line Id: " + subOrderDetail.getLineId());
  System.out.println("Item Number: " + subOrderDetail.getItemNumber());
}